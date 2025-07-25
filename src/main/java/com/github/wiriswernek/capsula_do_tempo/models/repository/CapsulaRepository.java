package com.github.wiriswernek.capsula_do_tempo.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.wiriswernek.capsula_do_tempo.models.entity.Capsula;

public interface CapsulaRepository extends JpaRepository<Capsula, String> {
	

}
