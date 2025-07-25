package com.github.wiriswernek.capsula_do_tempo.services;

import java.time.LocalDate;
import java.util.List;

import com.github.wiriswernek.capsula_do_tempo.models.dto.MensagemDTO;

public interface MensagemService {

	// Define service methods here, e.g., to manage Mensagens
	List<MensagemDTO> getAllMensagens(String capsulaId);
	MensagemDTO createMensagem(String capsulaId, MensagemDTO mensagemDTO);
	MensagemDTO updateMensagem(String capsulaId, String id, MensagemDTO mensagemDTO);
	void deleteMensagem(String capsulaId, String id);
	MensagemDTO getMensagemById(String capsulaId, String id);
	List<MensagemDTO> getMensagensByDateRange(String capsulaId, LocalDate startDate, LocalDate endDate);
}
