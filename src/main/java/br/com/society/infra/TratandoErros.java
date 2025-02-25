package br.com.society.infra;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.society.dto.MensagemDeErro;
import br.com.society.dto.Validar;

@ControllerAdvice
public class TratandoErros {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagemDeErro>aluguelNaoEncontrado(){
		var mensagem = new MensagemDeErro(HttpStatus.BAD_REQUEST,"Aluguel não encontrato !");
		return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
	}
	
    
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>validarCampos(MethodArgumentNotValidException  ex ){
		
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(Validar::new).toList());
	}
  }

