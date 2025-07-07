package io.pedroaugusto00.msfuncionarios.application.funcionario;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.msfuncionarios.domain.model.Funcionario;
import io.pedroaugusto00.msfuncionarios.domain.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastrarFuncionarioUseCase {

	private final FuncionarioRepository funcionarioRepository;
	
	public UUID salvar(Funcionario funcionario) {
		var salvo = funcionarioRepository.salvar(funcionario);
		return salvo.getId();
	}
}
