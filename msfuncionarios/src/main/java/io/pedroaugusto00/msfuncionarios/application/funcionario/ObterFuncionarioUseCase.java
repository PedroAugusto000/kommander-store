package io.pedroaugusto00.msfuncionarios.application.funcionario;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.msfuncionarios.domain.model.Funcionario;
import io.pedroaugusto00.msfuncionarios.domain.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObterFuncionarioUseCase {

	private final FuncionarioRepository funcionarioRepository;
	
	public Optional<Funcionario> obterDetalhes(UUID id) {
		return funcionarioRepository.buscarPorId(id);
	}
}
