package io.pedroaugusto00.msfuncionarios.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.pedroaugusto00.msfuncionarios.api.dto.FuncionarioCadastroDTO;
import io.pedroaugusto00.msfuncionarios.api.dto.FuncionarioDTO;
import io.pedroaugusto00.msfuncionarios.domain.model.Funcionario;
import io.pedroaugusto00.msfuncionarios.domain.model.Roles;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

	Funcionario toEntity(FuncionarioDTO dto);
	FuncionarioDTO toDTO(Funcionario funcionario);

	@Mapping(target = "role", source = "roleNome")
	Funcionario fromCadastroDTO(FuncionarioCadastroDTO dto);

	default Roles map(String roleNome) {
		if (roleNome == null) return null;
		Roles r = new Roles();
		r.setNome(roleNome);
		return r;
	}
}