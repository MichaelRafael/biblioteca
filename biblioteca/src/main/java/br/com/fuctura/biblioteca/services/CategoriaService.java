package br.com.fuctura.biblioteca.services;

import br.com.fuctura.biblioteca.exceptions.ObjectNotFoundException;
import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if (cat.isPresent()) {
            return cat.get();
        }
        throw new ObjectNotFoundException("Categoria não Encontrada");
        //return cat.orElseThrow(() -> new ObjectNotFoundException("Categoria não Encontrada"));
    }

    public Categoria findByGenero(String genero) {
        Optional<Categoria> cat = categoriaRepository.findByGeneroContainingIgnoreCase(genero);
        if (cat.isPresent()) {
            return cat.get();
        }
        throw new ObjectNotFoundException("Categoria não Encontrada");
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        findByGenero(categoria);
        Categoria cat = categoriaRepository.save(categoria);
        return cat;
    }

    public Categoria update(Categoria categoria) {
        findById(categoria.getId());
        findByGenero(categoria);
        Categoria cat = categoriaRepository.save(categoria);
        return cat;
    }

    public void delete(Integer id) {
        Categoria cat = findById(id);
        if (!cat.getLivros().isEmpty()) {

            throw new DataIntegrityViolationException("Categoria possui livros, não pode ser deletada!");
        }
        categoriaRepository.deleteById(id);
    }


    private void findByGenero(Categoria categoria) {
        Optional<Categoria> cat = categoriaRepository.findByGenero(categoria.getGenero());
        if (cat.isPresent() && cat.get().getGenero().equals(categoria.getGenero())) {
            throw new IllegalArgumentException("Já existe uma categoria com este gênero");
        }
    }
}
