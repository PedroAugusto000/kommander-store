package io.pedroaugusto00.ms_produtos.controller.mapper;

import io.pedroaugusto00.ms_produtos.controller.dto.ProdutoAdminDTO;
import io.pedroaugusto00.ms_produtos.model.Produto;

public class ProdutoAdminMapper {

	public static ProdutoAdminDTO toAdminDTO(Produto produto) {
	    ProdutoAdminDTO dto = new ProdutoAdminDTO();
	    dto.setId(produto.getId());
	    dto.setNome(produto.getNome());
	    dto.setDataCriacao(produto.getDataCriacao());
	    dto.setAtivo(produto.getAtivo());
	    dto.setNomeCategoria(produto.getCategoria() != null ? produto.getCategoria().getNome() : null);
	    return dto;
	}

}
