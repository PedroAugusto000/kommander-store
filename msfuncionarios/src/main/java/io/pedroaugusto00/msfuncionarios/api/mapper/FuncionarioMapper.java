package io.pedroaugusto00.msfuncionarios.api.mapper;

import org.mapstruct.Mapper;

import io.pedroaugusto00.msfuncionarios.api.dto.FuncionarioDTO;
import io.pedroaugusto00.msfuncionarios.domain.model.Funcionario;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

	Funcionario toEntity(FuncionarioDTO dto);
	FuncionarioDTO toDTO(Funcionario funcionario);
}
