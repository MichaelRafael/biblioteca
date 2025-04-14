package com.sistema.biblioteca.repositories;

import com.sistema.biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    List<Livro> findByCategoriaId(Integer categoriaId);
    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id =:categoriaId")
    List<Livro> findAllLivrosByCategoriaId(@Param(value = "categoriaId") Integer categoriaId);

    List<Livro> findByCategoriaNomeContainingIgnoreCase(String nomeCategoria);
}
