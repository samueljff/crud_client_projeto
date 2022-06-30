package com.samueljf.crudclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.samueljf.crudclient.dto.ClientDTO;
import com.samueljf.crudclient.entities.Client;
import com.samueljf.crudclient.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		
		Page<Client> list = repository.findAll(pageRequest);
		
		return list.map(x -> new ClientDTO(x));
	}
}
