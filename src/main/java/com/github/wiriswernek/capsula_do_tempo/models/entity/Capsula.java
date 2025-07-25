package com.github.wiriswernek.capsula_do_tempo.models.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "capsulas")
@AllArgsConstructor
@NoArgsConstructor
public class Capsula {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao;

	@Column(name = "data_expiracao", nullable = false)
	private LocalDate dataExpiracao;

	@OneToMany(mappedBy = "capsula", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<Mensagem> mensagens;
}
