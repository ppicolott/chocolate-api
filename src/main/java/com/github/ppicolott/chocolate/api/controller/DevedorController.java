package com.github.ppicolott.chocolate.api.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/devedor/")
@Tag(name = "API de Devedores", description = "Dedicada a gerenciar os devedores de chocolate na equipe")
public class DevedorController {

	private static final Logger LOGGER = Logger.getLogger(DevedorController.class.getName());
	
	
	@Autowired
	public DevedorController() {
		// Constructor
	}

	@Operation(summary = "Devedor", description = "Description", tags = "Devedor")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Successful"),
			@ApiResponse(responseCode = "201", description = "Created") }
	)
	@RequestMapping(value = "/novo/{name}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<String> register(@PathVariable(name = "name", required = true) String name){

		LOGGER.info("LOG DE EXEMPLO");
		return null;
	}

}
