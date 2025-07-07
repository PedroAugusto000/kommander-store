package io.pedroaugusto00.msfuncionarios.infra.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringFuncionarioJpaRepository extends JpaRepository<FuncionarioEntity, UUID>{

}
