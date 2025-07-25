package com.github.wiriswernek.capsula_do_tempo.models.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CapsulaDTO {

	private String id;
	private String nome;
	private Integer qtdMensagens;
	private LocalDateTime dataCriacao;
	private LocalDate dataExpiracao;
}
