package io.pedroaugusto00.msfuncionarios.infra.persistence;

import java.time.LocalDate;
import java.util.UUID;

import io.pedroaugusto00.msfuncionarios.domain.model.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "funcionarios")
@Getter @Setter
public class FuncionarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String nome;
	private String email;
	private String senha;
	private LocalDate data_criacao;
	private Boolean ativo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "role_id", nullable=false)
	private RolesEntity role;
}
