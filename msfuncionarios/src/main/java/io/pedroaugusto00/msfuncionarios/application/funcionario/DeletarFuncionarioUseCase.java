package io.pedroaugusto00.msfuncionarios.application.funcionario;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.msfuncionarios.domain.model.Funcionario;
import io.pedroaugusto00.msfuncionarios.domain.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeletarFuncionarioUseCase {

	private final FuncionarioRepository funcionarioRepository;
	
	public void deletar(UUID id) {
		Funcionario funcionario = funcionarioRepository.buscarPorId(id)
				.orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
		funcionarioRepository.deletar(funcionario);
	}
}
