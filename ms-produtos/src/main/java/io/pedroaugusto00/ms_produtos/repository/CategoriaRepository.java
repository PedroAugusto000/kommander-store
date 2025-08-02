package io.pedroaugusto00.ms_produtos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pedroaugusto00.ms_produtos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID>{

}
