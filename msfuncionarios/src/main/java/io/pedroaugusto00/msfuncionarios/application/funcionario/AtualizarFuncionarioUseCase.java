package io.pedroaugusto00.msfuncionarios.application.funcionario;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.msfuncionarios.domain.model.Funcionario;
import io.pedroaugusto00.msfuncionarios.domain.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtualizarFuncionarioUseCase {

	private final FuncionarioRepository funcionarioRepository;
	
	public void atualizar (UUID id, Funcionario novosDados) {
		Funcionario funcionario = funcionarioRepository.buscarPorId(id)
				.orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
		
		funcionario.setNome(novosDados.getNome());
		funcionario.setEmail(novosDados.getEmail());
		funcionario.setSenha(novosDados.getSenha());
		funcionario.setRole(novosDados.getRole());
	}
}
