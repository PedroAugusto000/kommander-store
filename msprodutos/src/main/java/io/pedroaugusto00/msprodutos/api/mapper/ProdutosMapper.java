package io.pedroaugusto00.msprodutos.api.mapper;

import org.mapstruct.Mapper;

import io.pedroaugusto00.msprodutos.api.dto.ProdutosDTO;
import io.pedroaugusto00.msprodutos.dominio.model.Produtos;

@Mapper(componentModel =  "spring")
public interface ProdutosMapper {
	
	Produtos toEntity(ProdutosDTO dto);
	
	ProdutosDTO toDTO(Produtos produtos);
}
