package com.samueljf.crudclient.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samueljf.crudclient.dto.ClientDTO;
import com.samueljf.crudclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linePerPage", defaultValue = "12") Integer linePerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy){
		
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		Page<ClientDTO> list = service.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
}
