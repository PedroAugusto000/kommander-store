package io.pedroaugusto00.msfuncionarios.infra.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import io.pedroaugusto00.msfuncionarios.domain.model.Funcionario;
import io.pedroaugusto00.msfuncionarios.domain.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FuncionarioRepositoryJpa implements FuncionarioRepository{

	private final SpringFuncionarioJpaRepository jpa;
	private final FuncionarioEntityMapper mapper;
	
	@Override
	public Funcionario salvar(Funcionario funcionario) {
		FuncionarioEntity salvo = jpa.save(mapper.toEntity(funcionario));
		return mapper.toDomain(salvo);
	}
	
	@Override
	public Optional<Funcionario> buscarPorId(UUID id) {
		return jpa.findById(id).map(mapper::toDomain);
	}
	
	@Override
	
	public void deletar(Funcionario funcionario) {
		jpa.delete(mapper.toEntity(funcionario));
	}
}
