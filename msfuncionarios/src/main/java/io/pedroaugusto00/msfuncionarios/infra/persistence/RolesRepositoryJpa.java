package io.pedroaugusto00.msfuncionarios.infra.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import io.pedroaugusto00.msfuncionarios.domain.model.Roles;
import io.pedroaugusto00.msfuncionarios.domain.repository.RolesRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RolesRepositoryJpa implements RolesRepository{

	private final RoleEntityMapper mapper;
	private final SpringRoleJpaRepository jpa;
	
	@Override
	public Optional<Roles> buscarPorId(UUID roleId) {
		return jpa.findById(roleId).map(mapper::toDomain);
	}
	
	@Override
	public Optional<Roles> buscarPorNome(String roleNome){
		return jpa.findByNome(roleNome).map(mapper::toDomain);
	}
}
