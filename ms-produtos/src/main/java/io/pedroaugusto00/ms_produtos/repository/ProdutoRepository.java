package io.pedroaugusto00.ms_produtos.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import io.pedroaugusto00.ms_produtos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID>, JpaSpecificationExecutor<Produto>{

	List<Produto> findAll();
	List<Produto> findAllByAtivoTrue();
	Page<Produto> findAllByCategoriaId(UUID categoriaId, Pageable pageable);
}
