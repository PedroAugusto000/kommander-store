package io.pedroaugusto00.msfuncionarios.infra.persistence;

import org.mapstruct.Mapper;

import io.pedroaugusto00.msfuncionarios.domain.model.Roles;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {

    RolesEntity toEntity(Roles role);

    Roles toDomain(RolesEntity entity);
}
