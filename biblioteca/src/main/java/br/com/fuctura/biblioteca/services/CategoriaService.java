package br.com.fuctura.biblioteca.services;

import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return cat.orElse(null);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }


    public Categoria save(Categoria categoria) {
        Categoria cat = categoriaRepository.save(categoria);
        return cat;
    }

    public Categoria update(Categoria categoria) {
        Categoria cat = categoriaRepository.save(categoria);
        return cat;
    }

    public void delete(Integer id){
       categoriaRepository.deleteById(id);

    }
}
