package com.github.wiriswernek.capsula_do_tempo.models.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensagemDTO {

	private String id;
	private String conteudo;
	private String nomeCriador;
	private String emailCriador;
	private String capsulaId;
	private LocalDate dataEnvio;
	private LocalDateTime dataCriacao;
	private Boolean eviada;
}
