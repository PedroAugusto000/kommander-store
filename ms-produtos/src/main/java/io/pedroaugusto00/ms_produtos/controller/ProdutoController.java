package io.pedroaugusto00.ms_produtos.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.pedroaugusto00.ms_produtos.controller.dto.ProdutoDTO;
import io.pedroaugusto00.ms_produtos.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> consultarTodosAtivos() {
		return ResponseEntity.ok(produtoService.consultarTodosAtivos());
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> criar(@RequestBody ProdutoDTO dto) {
		return ResponseEntity.ok(produtoService.criar(dto));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProdutoDTO> consultarPorId(@PathVariable UUID id) {
		return ResponseEntity.ok(produtoService.consultarPorId(id));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ProdutoDTO> atualizarPorId(@RequestBody ProdutoDTO dto, @PathVariable UUID id) {
		return ResponseEntity.ok(produtoService.atualizarPorId(dto, id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ProdutoDTO> deletarPorId(@PathVariable UUID id) {
		produtoService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<ProdutoDTO>> consultarTodos() {
		return ResponseEntity.ok(produtoService.consultarTodos());
	}
}
