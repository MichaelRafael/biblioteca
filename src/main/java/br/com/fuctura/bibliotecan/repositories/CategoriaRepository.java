package br.com.fuctura.bibliotecan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fuctura.bibliotecan.models.Categoria;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNomeIgnoreCaseContaining(String nome);
}
