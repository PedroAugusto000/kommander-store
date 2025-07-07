package io.pedroaugusto00.msprodutos.infra.persistence;

import org.mapstruct.Mapper;

import io.pedroaugusto00.msprodutos.dominio.model.Produtos;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {
	ProdutosEntity toEntity(Produtos produtos);
	Produtos toDomain(ProdutosEntity entity);
}
