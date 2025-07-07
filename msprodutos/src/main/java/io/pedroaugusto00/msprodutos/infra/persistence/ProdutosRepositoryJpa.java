package io.pedroaugusto00.msprodutos.infra.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import io.pedroaugusto00.msprodutos.dominio.model.Produtos;
import io.pedroaugusto00.msprodutos.dominio.repository.ProdutosRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProdutosRepositoryJpa implements ProdutosRepository {

    private final SpringProdutoJpaRepository jpa;
    private final ProdutoEntityMapper mapper;

    @Override
    public Produtos salvar(Produtos produto) {
        ProdutosEntity salvo = jpa.save(mapper.toEntity(produto));
        return mapper.toDomain(salvo);
    }

    @Override
    public Optional<Produtos> buscarPorId(UUID id) {
        return jpa.findById(id).map(mapper::toDomain);
    }

    @Override
    public void deletar(Produtos produto) {
        jpa.delete(mapper.toEntity(produto));
    }
}
