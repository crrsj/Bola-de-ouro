package br.com.society.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.society.enums.StatusAluguel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AluguelDto {
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate data;
	@NotBlank(message = "não pode estar em branco !")
	private String nome;
	@NotBlank(message = "não pode estar em branco !")
	private String telefone;
	@NotBlank(message = "não pode estar em branco !")
	private String rg;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
	@NotNull(message = "não pode estar em branco !")
	private Integer qtdHoras;	
	private Double valorHora;	
	private Double total;
	private String obs;
	private StatusAluguel status;

}
