package io.pedroaugusto00.msfuncionarios.api.dto;

public record FuncionarioCadastroDTO(
		String nome,
		String email,
		String senha,
		String roleNome
	) {}
