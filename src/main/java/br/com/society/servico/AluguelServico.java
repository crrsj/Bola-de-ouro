package br.com.society.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.society.dto.AluguelDto;
import br.com.society.dto.AtualizarAluguel;
import br.com.society.entidade.Aluguel;
import br.com.society.enums.StatusAluguel;
import br.com.society.repositorio.AluguelRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AluguelServico {
	
	private final AluguelRepositorio aluguelRepositorio;
	
	public Aluguel criarAluguel(AluguelDto aluguelDto) {
		var criar = new Aluguel(aluguelDto);
		criar.setTotal(criar.getQtdHoras() * criar.getValorHora());
		criar.setStatus(StatusAluguel.ALUGADO);
		return aluguelRepositorio.save(criar);
	}
	
	public List<Aluguel> listarAlugueis(Pageable pageable){
		return aluguelRepositorio.findAll(pageable).toList();
	}

	public Aluguel buscarPorId(Long id) {
		Optional<Aluguel>buscar = aluguelRepositorio.findById(id);
		return buscar.orElseThrow();
	}
	
	public Aluguel atualizarAluguel(AtualizarAluguel aluguel,Long id) {
		var atualizar = new Aluguel(aluguel);
		atualizar.setId(id);
		return aluguelRepositorio.save(atualizar);
	}
	
	public void excluirAluguel(Long id) {
		aluguelRepositorio.deleteById(id);
	}
	
	
}
