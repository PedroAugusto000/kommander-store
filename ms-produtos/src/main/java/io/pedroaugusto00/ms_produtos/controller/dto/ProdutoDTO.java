package io.pedroaugusto00.ms_produtos.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import io.pedroaugusto00.ms_produtos.model.Categoria;

public class ProdutoDTO {

	private UUID id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Integer estoque;
	private LocalDateTime dataCriacao;
	private Boolean ativo;
	private UUID categoriaId;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public UUID getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(UUID categoriaId) {
		this.categoriaId = categoriaId;
	}
}
