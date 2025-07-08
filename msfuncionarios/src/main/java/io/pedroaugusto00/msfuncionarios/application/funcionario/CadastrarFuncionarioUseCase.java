package io.pedroaugusto00.msfuncionarios.application.funcionario;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.msfuncionarios.domain.model.Funcionario;
import io.pedroaugusto00.msfuncionarios.domain.model.Roles;
import io.pedroaugusto00.msfuncionarios.domain.repository.FuncionarioRepository;
import io.pedroaugusto00.msfuncionarios.domain.repository.RolesRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CadastrarFuncionarioUseCase {

	private final FuncionarioRepository funcionarioRepository;
	private final RolesRepository rolesRepository;

	public UUID salvar(Funcionario funcionario) {
		// Aqui que tu resolve o bagulho
		String roleNome = funcionario.getRole() != null ? funcionario.getRole().getNome() : null;
		
		if (roleNome == null) {
			throw new RuntimeException("Nome da role não informado");
		}

		Roles role = rolesRepository.buscarPorNome(roleNome)
			.orElseThrow(() -> new RuntimeException("Role [" + roleNome + "] não encontrada"));

		funcionario.setRole(role);

		var salvo = funcionarioRepository.salvar(funcionario);
		return salvo.getId();
	}
}
