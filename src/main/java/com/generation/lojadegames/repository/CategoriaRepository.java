package com.generation.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojadegames.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	 // Busca por descrição (ignorando maiúsculas/minúsculas)
    public List<Categoria> findAllByNomeContainingIgnoreCase(String Nome);
    // SELECT * FROM tb_produto WHERE descricao ILIKE '%?%';

}
