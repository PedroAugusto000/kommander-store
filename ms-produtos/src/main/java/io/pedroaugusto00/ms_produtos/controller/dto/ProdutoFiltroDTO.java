package io.pedroaugusto00.ms_produtos.controller.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoFiltroDTO {
    private String nome;
    private String descricao;
    private UUID categoriaId;
    private BigDecimal precoMin;
    private BigDecimal precoMax;
    private Integer estoqueMin;
    private Integer estoqueMax;
    private Boolean ativo = true; // padrão só buscar os ativos
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
	public UUID getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(UUID categoriaId) {
		this.categoriaId = categoriaId;
	}
	public BigDecimal getPrecoMin() {
		return precoMin;
	}
	public void setPrecoMin(BigDecimal precoMin) {
		this.precoMin = precoMin;
	}
	public BigDecimal getPrecoMax() {
		return precoMax;
	}
	public void setPrecoMax(BigDecimal precoMax) {
		this.precoMax = precoMax;
	}
	public Integer getEstoqueMin() {
		return estoqueMin;
	}
	public void setEstoqueMin(Integer estoqueMin) {
		this.estoqueMin = estoqueMin;
	}
	public Integer getEstoqueMax() {
		return estoqueMax;
	}
	public void setEstoqueMax(Integer estoqueMax) {
		this.estoqueMax = estoqueMax;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
