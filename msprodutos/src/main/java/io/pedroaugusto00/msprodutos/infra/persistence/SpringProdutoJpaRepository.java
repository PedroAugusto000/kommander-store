package io.pedroaugusto00.msprodutos.infra.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringProdutoJpaRepository extends JpaRepository<ProdutosEntity, UUID> {
    // Aqui tu pode meter query personalizada se precisar depois
}
