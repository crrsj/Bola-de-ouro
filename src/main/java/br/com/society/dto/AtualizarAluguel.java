package br.com.society.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AtualizarAluguel {
	  private Long id;		 
	  private LocalDate data;
	  private String nome;
	  private String telefone;
	  private String rg;
	  private String obs;

}
