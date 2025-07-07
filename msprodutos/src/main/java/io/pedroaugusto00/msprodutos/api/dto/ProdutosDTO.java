package io.pedroaugusto00.msprodutos.api.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutosDTO(
	UUID id,
	String nome,
	String descricao, 
	BigDecimal preco,
	Integer quantidade_estoque
) {}
