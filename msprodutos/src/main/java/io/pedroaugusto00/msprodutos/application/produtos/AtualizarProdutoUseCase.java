package io.pedroaugusto00.msprodutos.application.produtos;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.msprodutos.dominio.model.Produtos;
import io.pedroaugusto00.msprodutos.dominio.repository.ProdutosRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtualizarProdutoUseCase {

    private final ProdutosRepository produtosRepository;

    public void executar(UUID id, Produtos novosDados) {
        Produtos produtos = produtosRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtos.setNome(novosDados.getNome());
        produtos.setDescricao(novosDados.getDescricao());
        produtos.setPreco(novosDados.getPreco());
        produtos.setQuantidadeEstoque(novosDados.getQuantidadeEstoque());

        produtosRepository.salvar(produtos);
    }
}
