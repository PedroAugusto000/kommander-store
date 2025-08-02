package io.pedroaugusto00.ms_produtos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.pedroaugusto00.ms_produtos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID>{

}
