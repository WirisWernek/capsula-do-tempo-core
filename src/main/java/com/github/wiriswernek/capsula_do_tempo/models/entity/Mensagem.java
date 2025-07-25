package com.github.wiriswernek.capsula_do_tempo.models.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "mensagens")
@AllArgsConstructor
@NoArgsConstructor
public class Mensagem {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "conteudo", nullable = false)
	private String conteudo;

	@Column(name = "nome_criador", nullable = false)
	private String nomeCriador;

	@Column(name = "email_criador", nullable = false)
	private String emailCriador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "capsula_id", nullable = false)
	private Capsula capsula;

	@Column(name = "data_envio", nullable = false)
	private LocalDate dataEnvio;

	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao;

	@Column(name = "eviada", nullable = false)
	private Boolean eviada;
}
