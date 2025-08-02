package io.pedroaugusto00.ms_produtos.controller.mapper;

import io.pedroaugusto00.ms_produtos.controller.dto.ProdutoDTO;
import io.pedroaugusto00.ms_produtos.model.Categoria;
import io.pedroaugusto00.ms_produtos.model.Produto;

public class ProdutoMapper {

	public static Produto toEntity(ProdutoDTO dto) {
		if(dto == null) return null;
		
		Produto produto = new Produto();
		
		produto.setId(dto.getId());
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPreco(dto.getPreco());
		produto.setEstoque(dto.getEstoque());
		produto.setAtivo(dto.getAtivo());
		
		if(dto.getCategoriaId() != null) {
			Categoria categoria = new Categoria();
			categoria.setId(dto.getCategoriaId());
			produto.setCategoria(categoria);
		}
		
		return produto;
	}
	
	public static ProdutoDTO toDTO(Produto produto) {
		if(produto == null) return null;
		
		ProdutoDTO dto = new ProdutoDTO();
		
		dto.setId(produto.getId());
		dto.setNome(produto.getNome());
		dto.setDescricao(produto.getDescricao());
		dto.setPreco(produto.getPreco());
		dto.setEstoque(produto.getEstoque());
		dto.setAtivo(produto.getAtivo());
		
		if(produto.getCategoria() != null) {
			dto.setCategoriaId(produto.getCategoria().getId());
		}
		
		return dto;
	}
}
