package io.pedroaugusto00.msfuncionarios.api.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pedroaugusto00.msfuncionarios.api.dto.FuncionarioCadastroDTO;
import io.pedroaugusto00.msfuncionarios.api.dto.FuncionarioDTO;
import io.pedroaugusto00.msfuncionarios.api.mapper.FuncionarioMapper;
import io.pedroaugusto00.msfuncionarios.application.funcionario.AtualizarFuncionarioUseCase;
import io.pedroaugusto00.msfuncionarios.application.funcionario.CadastrarFuncionarioUseCase;
import io.pedroaugusto00.msfuncionarios.application.funcionario.DeletarFuncionarioUseCase;
import io.pedroaugusto00.msfuncionarios.application.funcionario.ObterFuncionarioUseCase;
import io.pedroaugusto00.msfuncionarios.domain.model.Funcionario;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("funcionario")
@RequiredArgsConstructor
public class FuncionarioController implements GenericController{

	private final CadastrarFuncionarioUseCase cadastrarFuncionario;
	private final AtualizarFuncionarioUseCase atualizarFuncionario;
	private final ObterFuncionarioUseCase obterFuncionario;
	private final DeletarFuncionarioUseCase deletarFuncionario;
	private final FuncionarioMapper funcionarioMapper;
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody FuncionarioCadastroDTO dto) {
		Funcionario funcionario = funcionarioMapper.fromCadastroDTO(dto);
		UUID id = cadastrarFuncionario.salvar(funcionario);
		var url = gerarHeaderLocation(id);
		return ResponseEntity.created(url).build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<FuncionarioDTO> obterDetalhes(@PathVariable("id") String id) {
		return obterFuncionario.obterDetalhes(UUID.fromString(id))
				.map(funcionario -> ResponseEntity.ok(funcionarioMapper.toDTO(funcionario)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(@PathVariable("id") String id, @RequestBody FuncionarioDTO funcionarioDTO) {
		Funcionario entidadeAux = funcionarioMapper.toEntity(funcionarioDTO);
		atualizarFuncionario.atualizar(UUID.fromString(id), entidadeAux);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
		deletarFuncionario.deletar(UUID.fromString(id));
		return ResponseEntity.noContent().build();
	}
}
