package io.pedroaugusto00.msprodutos.infra.persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produtos")
@Getter @Setter
public class ProdutosEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private LocalDate dataCriacao;
    private Boolean ativo;
}