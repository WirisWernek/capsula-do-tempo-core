package com.github.wiriswernek.capsula_do_tempo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wiriswernek.capsula_do_tempo.models.dto.CapsulaDTO;
import com.github.wiriswernek.capsula_do_tempo.models.dto.MensagemDTO;
import com.github.wiriswernek.capsula_do_tempo.services.CapsulaService;
import com.github.wiriswernek.capsula_do_tempo.services.MensagemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/capsulas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CapsulaController {

	private final CapsulaService capsulaService;
	private final MensagemService mensagemService;

	@GetMapping("/")
	public List<CapsulaDTO> getAllCapsulas() {
		return capsulaService.getAllCapsulas();
	}

	@PostMapping("/")
	public CapsulaDTO createCapsula(@RequestBody CapsulaDTO capsulaDTO) {
		return capsulaService.createCapsula(capsulaDTO);
	}

	@PutMapping("/{id}")
	public CapsulaDTO updateCapsula(@PathVariable String id, @RequestBody CapsulaDTO capsulaDTO) {
		return capsulaService.updateCapsula(id, capsulaDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteCapsula(@PathVariable String id) {
		capsulaService.deleteCapsula(id);
	}

	@GetMapping("/{id}")
	public CapsulaDTO getCapsulaById(@PathVariable String id) {
		return capsulaService.getCapsulaById(id);
	}

	@GetMapping("/{id}/mensagens")
	public List<MensagemDTO> getMensagensByCapsulaId(@PathVariable String id) {
		return mensagemService.getAllMensagens(id);
	}

	@PostMapping("/{id}/mensagens")
	public MensagemDTO createMensagem(@PathVariable String id, @RequestBody MensagemDTO mensagemDTO) {
		return mensagemService.createMensagem(id, mensagemDTO);
	}

	@PutMapping("/{capsulaId}/mensagens/{id}")
	public MensagemDTO updateMensagem(@PathVariable String capsulaId, @PathVariable String id, @RequestBody MensagemDTO mensagemDTO) {
		return mensagemService.updateMensagem(capsulaId, id, mensagemDTO);
	}

	@DeleteMapping("/{capsulaId}/mensagens/{id}")
	public void deleteMensagem(@PathVariable String capsulaId, @PathVariable String id) {
		mensagemService.deleteMensagem(capsulaId, id);
	}

	@GetMapping("/{capsulaId}/mensagens/{id}")
	public MensagemDTO getMensagemById(@PathVariable String capsulaId, @PathVariable String id) {
		return mensagemService.getMensagemById(capsulaId, id);
	}

	@GetMapping("/test")
	public String testEndpoint() {
		return "Capsula do Tempo API is running!";
	}
}
