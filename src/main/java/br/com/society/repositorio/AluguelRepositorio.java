package br.com.society.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.society.entidade.Aluguel;

public interface AluguelRepositorio extends JpaRepository<Aluguel, Long> {

}
