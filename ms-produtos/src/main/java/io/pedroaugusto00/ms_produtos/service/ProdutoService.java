package io.pedroaugusto00.ms_produtos.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.pedroaugusto00.ms_produtos.controller.dto.ProdutoAdminDTO;
import io.pedroaugusto00.ms_produtos.controller.dto.ProdutoDTO;
import io.pedroaugusto00.ms_produtos.controller.dto.ProdutoFiltroDTO;
import io.pedroaugusto00.ms_produtos.controller.mapper.ProdutoAdminMapper;
import io.pedroaugusto00.ms_produtos.controller.mapper.ProdutoMapper;
import io.pedroaugusto00.ms_produtos.model.Categoria;
import io.pedroaugusto00.ms_produtos.model.Produto;
import io.pedroaugusto00.ms_produtos.repository.CategoriaRepository;
import io.pedroaugusto00.ms_produtos.repository.ProdutoRepository;
import io.pedroaugusto00.ms_produtos.repository.specs.ProdutoSpecification;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	private final CategoriaRepository categoriaRepository;

	public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
		this.produtoRepository = produtoRepository;
		this.categoriaRepository = categoriaRepository;
	}
	
	public ProdutoDTO criar(ProdutoDTO dto) {
		Produto produto = ProdutoMapper.toEntity(dto);
		Produto salvo = produtoRepository.save(produto);
		return ProdutoMapper.toDTO(salvo);
	}
	
	public ProdutoDTO consultarPorId(UUID id) {
		Produto consulta = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
		return ProdutoMapper.toDTO(consulta);
	}
	
	public ProdutoDTO atualizarPorId(ProdutoDTO dto, UUID id) {
		Produto produtoExiste = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
		
		Categoria categoriaExiste = categoriaRepository.findById(dto.getCategoriaId()).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada!"));
		
		produtoExiste.setNome(dto.getNome());
		produtoExiste.setDescricao(dto.getDescricao());
		produtoExiste.setPreco(dto.getPreco());
		produtoExiste.setEstoque(dto.getEstoque());
		produtoExiste.setAtivo(dto.getAtivo());
		produtoExiste.setCategoria(categoriaExiste);
		
		Produto atualizado = produtoRepository.save(produtoExiste);
		return ProdutoMapper.toDTO(atualizado);	
	}
	
	public void deletarPorId(UUID id) {
		produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
		produtoRepository.deleteById(id);
	}
	
	public List<ProdutoDTO> consultarTodos() {
		List<Produto> busca = produtoRepository.findAll();
		return busca.stream().map(ProdutoMapper::toDTO).collect(Collectors.toList());
	}
	
	public List<ProdutoDTO> consultarTodosAtivos() {
		List<Produto> busca = produtoRepository.findAllByAtivoTrue();
		return busca.stream().map(ProdutoMapper::toDTO).collect(Collectors.toList());
	}
	
	public List<ProdutoDTO> consultarComFiltro(ProdutoFiltroDTO filtro) {
		List<Produto> encontrados = produtoRepository.findAll(ProdutoSpecification.filtrar(filtro));
		return encontrados.stream().map(ProdutoMapper::toDTO).collect(Collectors.toList());
	}
	
	public Page<ProdutoDTO> listarPorCategoria(UUID categoriaId, Pageable pageable) {
		Page<Produto> pagina = produtoRepository.findAllByCategoriaId(categoriaId, pageable);
		return pagina.map(ProdutoMapper::toDTO);
	}
	
	public List<ProdutoAdminDTO> listarProdutosAdmin() {
	    List<Produto> produtos = produtoRepository.findAll();
	    return produtos.stream()
	        .map(ProdutoAdminMapper::toAdminDTO)
	        .collect(Collectors.toList());
	}
}
