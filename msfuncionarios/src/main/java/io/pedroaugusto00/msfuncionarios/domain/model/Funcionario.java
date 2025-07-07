package io.pedroaugusto00.msfuncionarios.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Funcionario {

	private UUID id;
	private String nome;
	private String email;
	private String senha;
	private LocalDate data_criacao;
	private Boolean ativo;
	private Roles role;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public LocalDate getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(LocalDate data_criacao) {
		this.data_criacao = data_criacao;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	
}
