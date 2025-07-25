package com.github.wiriswernek.capsula_do_tempo.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.wiriswernek.capsula_do_tempo.models.dto.MensagemDTO;
import com.github.wiriswernek.capsula_do_tempo.models.entity.Capsula;
import com.github.wiriswernek.capsula_do_tempo.models.entity.Mensagem;
import com.github.wiriswernek.capsula_do_tempo.models.repository.CapsulaRepository;
import com.github.wiriswernek.capsula_do_tempo.models.repository.MensagemRepository;
import com.github.wiriswernek.capsula_do_tempo.services.MensagemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MensagemServiceImpl implements MensagemService {

	private final MensagemRepository mensagemRepository;
	private final CapsulaRepository capsulaRepository;

	@Override
	public List<MensagemDTO> getAllMensagens(String capsulaId) {
		return mensagemRepository.findByCapsulaId(capsulaId)
				.stream()
				.map(mensagem -> this.convertToDTO(mensagem))
				.toList();
	}

	@Override
	public MensagemDTO createMensagem(String capsulaId, MensagemDTO mensagemDTO) {
		Capsula capsula = capsulaRepository.findById(capsulaId)
				.orElseThrow(() -> new RuntimeException("Capsula not found with id: " + capsulaId));

		Mensagem mensagem = Mensagem.builder()
				.capsula(capsula)
				.conteudo(mensagemDTO.getConteudo())
				.dataCriacao(LocalDateTime.now())
				.eviada(false)
				.dataEnvio(mensagemDTO.getDataEnvio())
				.emailCriador(mensagemDTO.getEmailCriador())
				.nomeCriador(mensagemDTO.getNomeCriador())
				.build();

		mensagem = mensagemRepository.save(mensagem);
		return this.convertToDTO(mensagem);
	}

	@Override
	public MensagemDTO updateMensagem(String capsulaId, String id, MensagemDTO mensagemDTO) {
		Mensagem mensagem = mensagemRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Mensagem not found with id: " + id));

		if (!mensagem.getCapsula().getId().equals(capsulaId)) {
			throw new RuntimeException("Mensagem does not belong to the specified Capsula");
		}

		mensagem.setConteudo(mensagemDTO.getConteudo());
		mensagem.setDataEnvio(mensagemDTO.getDataEnvio());
		mensagem.setEmailCriador(mensagemDTO.getEmailCriador());
		mensagem.setNomeCriador(mensagemDTO.getNomeCriador());
		mensagem = mensagemRepository.save(mensagem);
		return this.convertToDTO(mensagem);
	}

	@Override
	public void deleteMensagem(String capsulaId, String id) {
		Mensagem mensagem = mensagemRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Mensagem not found with id: " + id));
		if (!mensagem.getCapsula().getId().equals(capsulaId)) {
			throw new RuntimeException("Mensagem does not belong to the specified Capsula");
		}

		mensagemRepository.deleteById(mensagem.getId());
	}

	@Override
	public MensagemDTO getMensagemById(String capsulaId, String id) {
		Mensagem mensagem = mensagemRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Mensagem not found with id: " + id));
		if (!mensagem.getCapsula().getId().equals(capsulaId)) {
			throw new RuntimeException("Mensagem does not belong to the specified Capsula");
		}

		return this.convertToDTO(mensagem);
	}

	@Override
	public List<MensagemDTO> getMensagensByDateRange(String capsulaId, LocalDate startDate, LocalDate endDate) {
		List<Mensagem> mensagens = mensagemRepository.findByCapsulaId(capsulaId);
		return mensagens.stream()
				.filter(mensagem -> !mensagem.getDataEnvio().isBefore(startDate) && !mensagem.getDataEnvio().isAfter(endDate))
				.map(mensagem -> this.convertToDTO(mensagem))
				.toList();
	}

	private MensagemDTO convertToDTO(Mensagem mensagem) {
		return MensagemDTO.builder()
				.capsulaId(mensagem.getCapsula().getId())
				.conteudo(mensagem.getConteudo())
				.dataCriacao(mensagem.getDataCriacao())
				.id(mensagem.getId())
				.eviada(mensagem.getEviada())
				.dataEnvio(mensagem.getDataEnvio())
				.emailCriador(mensagem.getEmailCriador())
				.nomeCriador(mensagem.getNomeCriador())
				.build();
	}

}
