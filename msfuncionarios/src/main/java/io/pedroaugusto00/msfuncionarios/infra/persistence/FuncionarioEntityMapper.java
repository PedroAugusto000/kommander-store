package io.pedroaugusto00.msfuncionarios.infra.persistence;

import org.mapstruct.Mapper;

import io.pedroaugusto00.msfuncionarios.domain.model.Funcionario;

@Mapper(componentModel = "spring", uses = {RoleEntityMapper.class})
public interface FuncionarioEntityMapper {
	
	FuncionarioEntity toEntity(Funcionario funcionario);
	Funcionario toDomain(FuncionarioEntity entity);
}
