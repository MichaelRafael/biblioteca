package com.sistema.biblioteca.services;

import com.sistema.biblioteca.exceptions.ObjectNotFoundException;
import com.sistema.biblioteca.models.Livro;
import com.sistema.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return livro.get();
        }
        throw new ObjectNotFoundException("Livro não encontrado");
    }

    public List<Livro> findAll(Integer categoriaId) {
        categoriaService.findById(categoriaId);
        return livroRepository.findByCategoriaId(categoriaId);
    }

    public List<Livro> findByCategoriaNome(String nomeCategoria) {
        categoriaService.buscarPorNome(nomeCategoria);
        return livroRepository.findByCategoriaNomeContainingIgnoreCase(nomeCategoria);
    }
}
