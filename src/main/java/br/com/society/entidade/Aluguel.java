package br.com.society.entidade;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.society.dto.AluguelDto;
import br.com.society.dto.AtualizarAluguel;
import br.com.society.enums.StatusAluguel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Aluguel {
	

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;		 
	  private LocalDate data;
	  private String nome;
	  private String telefone;
	  private String rg;
	  private LocalTime horaEntrada;
	  private LocalTime horaSaida;
	  private Integer qtdHoras;
	  private Double valorHora;
	  private Double total;
	  private String obs;
	  @Enumerated(EnumType.STRING)
	  private StatusAluguel status;
	  
	  public Aluguel(AluguelDto aluguelDto) {
		this.data = aluguelDto.getData();
		this.nome = aluguelDto.getNome();
		this.telefone = aluguelDto.getTelefone();
		this.rg = aluguelDto.getRg();
		this.horaEntrada = aluguelDto.getHoraEntrada();
		this.horaSaida = aluguelDto.getHoraSaida();
		this.qtdHoras = aluguelDto.getQtdHoras();
		this.valorHora = aluguelDto.getValorHora();
		this.total = aluguelDto.getTotal();
		this.obs = aluguelDto.getObs();
		this.status = aluguelDto.getStatus();
		
	}

	public Aluguel(AtualizarAluguel aluguel) {
		this.id = aluguel.getId();
		this.data = aluguel.getData();
		this.nome = aluguel.getNome();
		this.telefone = aluguel.getTelefone();
		this.rg = aluguel.getRg();
		this.obs = aluguel.getObs();
	}
	  

}
