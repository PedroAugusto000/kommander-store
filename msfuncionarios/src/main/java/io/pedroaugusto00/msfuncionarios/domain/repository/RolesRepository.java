package io.pedroaugusto00.msfuncionarios.domain.repository;

import java.util.Optional;
import java.util.UUID;

import io.pedroaugusto00.msfuncionarios.domain.model.Roles;

public interface RolesRepository {

	Optional<Roles> buscarPorId(UUID roleId);
	Optional<Roles> buscarPorNome(String roleNome);
}
