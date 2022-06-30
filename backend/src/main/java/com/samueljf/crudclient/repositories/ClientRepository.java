package com.samueljf.crudclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samueljf.crudclient.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
