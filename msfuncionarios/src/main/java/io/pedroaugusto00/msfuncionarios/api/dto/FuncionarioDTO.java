package io.pedroaugusto00.msfuncionarios.api.dto;

import java.time.LocalDate;
import java.util.UUID;

import io.pedroaugusto00.msfuncionarios.domain.model.Roles;

public record FuncionarioDTO (
		
		UUID id,
		String nome,
		String email, 
		String senha, 
		Roles role	
	) {}
