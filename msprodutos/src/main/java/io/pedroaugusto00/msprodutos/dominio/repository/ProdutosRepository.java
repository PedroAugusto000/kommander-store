package io.pedroaugusto00.msprodutos.dominio.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.pedroaugusto00.msprodutos.dominio.model.Produtos;

public interface ProdutosRepository {
	Produtos salvar(Produtos produtos);
	Optional<Produtos> buscarPorId(UUID id);
	void deletar(Produtos produtos);
	
}
