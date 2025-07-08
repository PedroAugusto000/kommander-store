package io.pedroaugusto00.msfuncionarios.infra.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringRoleJpaRepository extends JpaRepository<RolesEntity, UUID>{
	Optional<RolesEntity> findByNome(String roleNome);
}
