package br.com.fuctura.bibliotecan.repositories;

import br.com.fuctura.bibliotecan.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    List<Livro> findAllByCategoriaId(Integer categoriaId);
}
