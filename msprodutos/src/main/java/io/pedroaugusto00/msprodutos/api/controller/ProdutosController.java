package io.pedroaugusto00.msprodutos.api.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.pedroaugusto00.msprodutos.api.dto.ProdutosDTO;
import io.pedroaugusto00.msprodutos.api.mapper.ProdutosMapper;
import io.pedroaugusto00.msprodutos.application.produtos.*;
import io.pedroaugusto00.msprodutos.dominio.model.Produtos;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutosController implements GenericController {

    private final CadastrarProdutoUseCase cadastrarProduto;
    private final ObterProdutoUseCase obterProduto;
    private final AtualizarProdutoUseCase atualizarProduto;
    private final DeletarProdutoUseCase deletarProduto;
    private final ProdutosMapper produtosMapper;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody ProdutosDTO produtosDTO) {
        Produtos produtos = produtosMapper.toEntity(produtosDTO);
        UUID id = cadastrarProduto.executar(produtos);
        var url = gerarHeaderLocation(id);
        return ResponseEntity.created(url).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutosDTO> obterDetalhes(@PathVariable("id") String id) {
        return obterProduto.executar(UUID.fromString(id))
                .map(produto -> ResponseEntity.ok(produtosMapper.toDTO(produto)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") String id, @RequestBody ProdutosDTO produtosDTO) {
        Produtos entidadeAux = produtosMapper.toEntity(produtosDTO);
        atualizarProduto.executar(UUID.fromString(id), entidadeAux);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        deletarProduto.executar(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
