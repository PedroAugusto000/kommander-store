package io.pedroaugusto00.msprodutos.application.produtos;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.msprodutos.dominio.model.Produtos;
import io.pedroaugusto00.msprodutos.dominio.repository.ProdutosRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastrarProdutoUseCase {

    private final ProdutosRepository produtoRepository;

    public UUID executar(Produtos produto) {
        var salvo = produtoRepository.salvar(produto);
        return salvo.getId(); 
    }
}
