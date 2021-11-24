package com.github.ppicolott.chocolate.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.ppicolott.chocolate.api.entity.DevedorEntity;
import com.github.ppicolott.chocolate.api.respository.DevedorRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/devedor/")
@Tag(name = "API de Devedores", description = "Dedicada a gerenciar os devedores de chocolate da equipe")
public class DevedorController {

	private static final Logger LOGGER = Logger.getLogger(DevedorController.class.getName());
	
	@Autowired
	private DevedorRepository devedorRepository;
	
	
	public DevedorController() {
	}
	
	@Operation(summary = "Retorna todos os picaretas cadastrados", description = "Description", tags = "Devedor")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Successful"),
			@ApiResponse(responseCode = "201", description = "Created") }
	)
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<DevedorEntity> listAll(){
		
		List<DevedorEntity> listTemp = new ArrayList<>(100);
		listTemp = this.devedorRepository.findAll();
		
		LOGGER.info("LOG DE EXEMPLO");
		return listTemp;
	}

	@Operation(summary = "Retorna o picareta", description = "Description", tags = "Devedor")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Successful"),
			@ApiResponse(responseCode = "201", description = "Created") }
	)
	@GetMapping(value = "/buscar/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Optional<DevedorEntity>> findById(@PathVariable(name = "uuid", required = true) String uuid){

		Optional<DevedorEntity> devedor = Optional.ofNullable(new DevedorEntity());
		
		devedor = this.devedorRepository.findById(StringUtils.normalizeSpace(uuid));
		
		LOGGER.info("LOG DE EXEMPLO");
		return ResponseEntity.ok().body(devedor);
	}
	
	@Operation(summary = "Cadastra um picareta no banco de dados", description = "Description", tags = "Devedor")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Successful"),
			@ApiResponse(responseCode = "201", description = "Created") }
	)
	@PostMapping(value = "/cadastrar/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<DevedorEntity> register(@PathVariable(name = "name", required = true) String name){

		DevedorEntity devedor = new DevedorEntity();
		devedor.setUuid(UUID.randomUUID().toString());
		devedor.setName(StringUtils.normalizeSpace(name));
		devedor.setQtd(0);
		
		this.devedorRepository.save(devedor);
		
		LOGGER.info("LOG DE EXEMPLO");
		return ResponseEntity.ok().body(devedor);
	}
	
	@Operation(summary = "Remove um picareta do banco de dados", description = "Description", tags = "Devedor")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Successful"),
			@ApiResponse(responseCode = "201", description = "Created") }
	)
	@DeleteMapping(value = "/remover/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Optional<DevedorEntity>> remove(@PathVariable(name = "uuid", required = true) String uuid){
		
		Optional<DevedorEntity> devedor = Optional.ofNullable(new DevedorEntity());
		String uuidRev = StringUtils.normalizeSpace(uuid);		
		
		if(uuidRev!=null) {
			devedor = this.devedorRepository.findById(uuidRev);
			this.devedorRepository.deleteById(uuidRev);
		}else {
			//Nothing
		}
		
		LOGGER.info("LOG DE EXEMPLO");
		return ResponseEntity.ok().body(devedor);
	}
	
	@Operation(summary = "Adiciona mais um pra conta", description = "Description", tags = "Devedor")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Successful"),
			@ApiResponse(responseCode = "201", description = "Created") }
	)
	@PutMapping(value = "/chocolate/somar/{uuid}/{qtd}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	
	public ResponseEntity<DevedorEntity> chocolateAdd(
			@PathVariable(name = "uuid", required = true) String uuid,
			@PathVariable(name = "qtd", required = true) Integer qtd
			){

		String uuidRev = StringUtils.normalizeSpace(uuid);
		DevedorEntity devedor = new DevedorEntity();
		
		if(uuidRev!=null) {
			devedor = this.devedorRepository.findById(uuidRev).get();
            devedor.setQtd(qtd);
            this.devedorRepository.save(devedor);
		}else {
			//Nothing
		}
		
		LOGGER.info("LOG DE EXEMPLO");
		return ResponseEntity.ok().body(devedor);
	}
	
}
