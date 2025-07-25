package com.github.wiriswernek.capsula_do_tempo.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.wiriswernek.capsula_do_tempo.models.dto.CapsulaDTO;
import com.github.wiriswernek.capsula_do_tempo.models.entity.Capsula;
import com.github.wiriswernek.capsula_do_tempo.models.repository.CapsulaRepository;
import com.github.wiriswernek.capsula_do_tempo.services.CapsulaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CapsulaServiceImpl implements CapsulaService {

	private final CapsulaRepository capsulaRepository;

	@Override
	public List<CapsulaDTO> getAllCapsulas() {
		return capsulaRepository.findAll()
				.stream()
				.map(capsula -> this.convertToDTO(capsula))
				.toList();
	}

	@Override
	public CapsulaDTO createCapsula(CapsulaDTO capsulaDTO) {
		Capsula capsula = Capsula.builder()
				.nome(capsulaDTO.getNome())
				.dataCriacao(LocalDateTime.now())
				.dataExpiracao(capsulaDTO.getDataExpiracao())
				.build();

		capsula = capsulaRepository.save(capsula);
		return this.convertToDTO(capsula);
	}

	@Override
	public CapsulaDTO updateCapsula(String id, CapsulaDTO capsulaDTO) {
		Capsula capsula = capsulaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Capsula not found with id: " + id));

		capsula.setNome(capsulaDTO.getNome());
		capsula.setDataExpiracao(capsulaDTO.getDataExpiracao());
		capsula = capsulaRepository.save(capsula);
		return this.convertToDTO(capsula);
	}

	@Override
	public void deleteCapsula(String id) {
		Capsula capsula = capsulaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Capsula not found with id: " + id));
		capsulaRepository.deleteById(capsula.getId());
	}

	@Override
	public CapsulaDTO getCapsulaById(String id) {
		Capsula capsula = capsulaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Capsula not found with id: " + id));
		return this.convertToDTO(capsula);
	}

	@Override
	public List<CapsulaDTO> getCapsulasByDateRange(LocalDate startDate, LocalDate endDate) {
		return capsulaRepository.findAll()
				.stream()
				.filter(capsula -> !capsula.getDataExpiracao().isBefore(startDate)
						&& !capsula.getDataExpiracao().isAfter(endDate))
				.map(capsula -> this.convertToDTO(capsula))
				.toList();
	}

	// TODO: Adionar a quantiodade de mensagens na capsula
	private CapsulaDTO convertToDTO(Capsula capsula) {
		// Convert Capsula entity to CapsulaDTO
		return CapsulaDTO.builder()
				.id(capsula.getId())
				.nome(capsula.getNome())
				.qtdMensagens(capsula.getMensagens() != null ? capsula.getMensagens().size() : 0)
				.dataCriacao(capsula.getDataCriacao())
				.dataExpiracao(capsula.getDataExpiracao())
				.build();
	}

}
