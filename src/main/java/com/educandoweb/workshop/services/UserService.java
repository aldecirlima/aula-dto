package com.educandoweb.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educandoweb.workshop.dto.UserDTO;
import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	
	/* Para transações somente de leitura pode-se colocar o transactional
	* com o parâmetro readOnly = true.
	* Caso necessite executar comandos no banco de dados, utilizar o Transactional sem
	* parametros e sem parênteses
	*/ 
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		User entity = repository.findById(id).get();
		UserDTO dto = new UserDTO(entity);
		return dto;
	};

}
