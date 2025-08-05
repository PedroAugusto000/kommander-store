package io.pedroaugusto00.ms_produtos.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import io.pedroaugusto00.ms_produtos.controller.dto.ProdutoFiltroDTO;
import io.pedroaugusto00.ms_produtos.model.Produto;
import jakarta.persistence.criteria.Predicate;

//Specification:  é tipo um filtro dinâmico. Ao invés de tu criar um monte de método fixo no repositório tu usa ela que monta os filtros na hora, baseado no que o cliente mandou na requisição
//Fábrica de filtros pra entidade Produto: Passa uma DTO com critérios e ela devolve uma consulta personalizada com filtros
public class ProdutoSpecification {

    public static Specification<Produto> filtrar(ProdutoFiltroDTO filtro) {
        return (root, query, builder) -> { // Root = Entidade principal (Produtos) | Query: query sendo construída | Builder: Construtor de condições, tipo =, >, LIKE...
            Predicate predicate = builder.conjunction(); // Esse é o ponto de partida: conjunction() cria um filtro que sempre retorna true (tipo um WHERE 1=1). Assim tu pode ir adicionando condições nele sem quebrar
            
            /*
             * Em todos os filtros a gente basicamente tá dizendo:
             * "Se o atributo foi preenchido no filtro, adiciona um WHERE nome LIKE %nome% ignorando maiusculo e minusculo"
            */
            
            // A condição do if basicamente diz: “Se o cliente mandou o nome no filtro, então filtra pelo nome. Se ele não mandou nada, ignora.”
            if (filtro.getNome() != null && !filtro.getNome().isEmpty()) {
                predicate = builder.and(predicate,
                    builder.like(builder.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));
            }

            if (filtro.getDescricao() != null && !filtro.getDescricao().isEmpty()) {
                predicate = builder.and(predicate,
                    builder.like(builder.lower(root.get("descricao")), "%" + filtro.getDescricao().toLowerCase() + "%"));
            }

            if (filtro.getCategoriaId() != null) {
                predicate = builder.and(predicate,
                    builder.equal(root.get("categoria").get("id"), filtro.getCategoriaId()));
            }

            if (filtro.getPrecoMin() != null) {
                predicate = builder.and(predicate,
                    builder.greaterThanOrEqualTo(root.get("preco"), filtro.getPrecoMin()));
            }

            if (filtro.getPrecoMax() != null) {
                predicate = builder.and(predicate,
                    builder.lessThanOrEqualTo(root.get("preco"), filtro.getPrecoMax()));
            }

            if (filtro.getEstoqueMin() != null) {
                predicate = builder.and(predicate,
                    builder.greaterThanOrEqualTo(root.get("estoque"), filtro.getEstoqueMin()));
            }

            if (filtro.getEstoqueMax() != null) {
                predicate = builder.and(predicate,
                    builder.lessThanOrEqualTo(root.get("estoque"), filtro.getEstoqueMax()));
            }

            if (filtro.getAtivo() != null) {
                predicate = builder.and(predicate,
                    builder.equal(root.get("ativo"), filtro.getAtivo()));
            }

            return predicate;
        };
    }
}