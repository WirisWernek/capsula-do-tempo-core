package com.github.wiriswernek.capsula_do_tempo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.wiriswernek.capsula_do_tempo.models.entity.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, String> {
	
	public List<Mensagem> findByCapsulaId(String capsulaId);
}
