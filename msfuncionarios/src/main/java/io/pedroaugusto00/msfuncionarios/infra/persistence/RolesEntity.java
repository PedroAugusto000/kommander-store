package io.pedroaugusto00.msfuncionarios.infra.persistence;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter @Setter
public class RolesEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
	private String descricao;
}
