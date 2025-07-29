package com.github.wiriswernek.capsula_do_tempo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.wiriswernek.capsula_do_tempo.models.dto.CapsulaDTO;
import com.github.wiriswernek.capsula_do_tempo.models.dto.MensagemDTO;
import com.github.wiriswernek.capsula_do_tempo.services.CapsulaService;
import com.github.wiriswernek.capsula_do_tempo.services.MensagemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/capsulas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "Capsula", description = "Endpoints for managing time capsules and their messages.")
public class CapsulaController {

	private final CapsulaService capsulaService;
	private final MensagemService mensagemService;

	@GetMapping(value = "/", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Retorna todas as cápsulas de tempo.")
	public List<CapsulaDTO> getAllCapsulas() {
		return capsulaService.getAllCapsulas();
	}

	@PostMapping(value = "/", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Cria uma nova cápsula de tempo.")
	public CapsulaDTO createCapsula(@RequestBody CapsulaDTO capsulaDTO) {
		return capsulaService.createCapsula(capsulaDTO);
	}

	@PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Atualiza uma cápsula de tempo existente.")
	public CapsulaDTO updateCapsula(@PathVariable String id, @RequestBody CapsulaDTO capsulaDTO) {
		return capsulaService.updateCapsula(id, capsulaDTO);
	}

	@DeleteMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Exclui uma cápsula de tempo pelo ID.")
	public void deleteCapsula(@PathVariable String id) {
		capsulaService.deleteCapsula(id);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Obtém uma cápsula de tempo pelo ID.")
	public CapsulaDTO getCapsulaById(@PathVariable String id) {
		return capsulaService.getCapsulaById(id);
	}

	@GetMapping(value = "/{id}/mensagens", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Obtém todas as mensagens de uma cápsula de tempo pelo ID.")
	public List<MensagemDTO> getMensagensByCapsulaId(@PathVariable String id) {
		return mensagemService.getAllMensagens(id);
	}

	@PostMapping(value = "/{id}/mensagens", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Cria uma nova mensagem em uma cápsula de tempo.")
	public MensagemDTO createMensagem(@PathVariable String id, @RequestBody MensagemDTO mensagemDTO) {
		return mensagemService.createMensagem(id, mensagemDTO);
	}

	@PutMapping(value = "/{capsulaId}/mensagens/{id}", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Atualiza uma mensagem em uma cápsula de tempo.")
	public MensagemDTO updateMensagem(@PathVariable String capsulaId, @PathVariable String id, @RequestBody MensagemDTO mensagemDTO) {
		return mensagemService.updateMensagem(capsulaId, id, mensagemDTO);
	}

	@DeleteMapping(value = "/{capsulaId}/mensagens/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Exclui uma mensagem de uma cápsula de tempo pelo ID.")
	public void deleteMensagem(@PathVariable String capsulaId, @PathVariable String id) {
		mensagemService.deleteMensagem(capsulaId, id);
	}

	@GetMapping(value = "/{capsulaId}/mensagens/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Obtém uma mensagem específica de uma cápsula de tempo pelo ID.")
	public MensagemDTO getMensagemById(@PathVariable String capsulaId, @PathVariable String id) {
		return mensagemService.getMensagemById(capsulaId, id);
	}
}
