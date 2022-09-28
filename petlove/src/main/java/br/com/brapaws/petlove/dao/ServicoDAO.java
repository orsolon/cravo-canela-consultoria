package br.com.brapaws.petlove.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brapaws.petlove.model.Servico;

public interface ServicoDAO extends JpaRepository<Servico, Integer>{

}
