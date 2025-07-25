package com.github.wiriswernek.capsula_do_tempo.services;

import java.time.LocalDate;
import java.util.List;

import com.github.wiriswernek.capsula_do_tempo.models.dto.CapsulaDTO;

public interface CapsulaService {
	// Define service methods here, e.g., to manage Capsulas
	List<CapsulaDTO> getAllCapsulas();
	CapsulaDTO createCapsula(CapsulaDTO capsulaDTO);
	CapsulaDTO updateCapsula(String id, CapsulaDTO capsulaDTO);
	void deleteCapsula(String id);
	CapsulaDTO getCapsulaById(String id);
	List<CapsulaDTO> getCapsulasByDateRange(LocalDate startDate, LocalDate endDate);	

}
