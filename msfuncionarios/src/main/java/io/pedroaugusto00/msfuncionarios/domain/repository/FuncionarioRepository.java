package io.pedroaugusto00.msfuncionarios.domain.repository;

import java.util.Optional;
import java.util.UUID;

import io.pedroaugusto00.msfuncionarios.domain.model.Funcionario;

public interface FuncionarioRepository {
	Funcionario salvar(Funcionario funcionario);
	Optional<Funcionario> buscarPorId(UUID id);
	void deletar(Funcionario funcionario);
}
