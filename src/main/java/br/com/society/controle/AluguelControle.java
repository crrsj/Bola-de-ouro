package br.com.society.controle;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.society.dto.AluguelDto;
import br.com.society.dto.AtualizarAluguel;
import br.com.society.entidade.Aluguel;
import br.com.society.servico.AluguelServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/society")
@RequiredArgsConstructor
public class AluguelControle {
	
	private final AluguelServico aluguelServico;
	
	
	@PostMapping   
	public ResponseEntity<Aluguel>criarAluguel(@RequestBody @Valid AluguelDto aluguelDto){
		var criar = aluguelServico.criarAluguel(aluguelDto);
		return new ResponseEntity<>(criar,HttpStatus.CREATED);
	}
	
	
    @GetMapping
	public ResponseEntity<List<Aluguel>>listarAlugueis(@PageableDefault(size = 5)Pageable pageable){
		var listar = aluguelServico.listarAlugueis(pageable);
		return new ResponseEntity<>(listar,HttpStatus.OK);
		
	}
    
    @GetMapping("/{id}")
    public ResponseEntity<Aluguel>buscarPorId(@PathVariable Long id){
    	var buscar = aluguelServico.buscarPorId(id);
    	return new ResponseEntity<>(buscar, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Aluguel>atualizarAluguel(@RequestBody @Valid AtualizarAluguel aluguel,@PathVariable Long id){
    	var atualizar = aluguelServico.atualizarAluguel(aluguel, id);
    	return new ResponseEntity<>(atualizar,HttpStatus.OK);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>excluirAluguel(@PathVariable Long id){
    	aluguelServico.excluirAluguel(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
