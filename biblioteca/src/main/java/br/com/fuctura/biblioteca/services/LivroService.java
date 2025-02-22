package br.com.fuctura.biblioteca.services;

import br.com.fuctura.biblioteca.dtos.LivroDto;
import br.com.fuctura.biblioteca.exceptions.ObjectNotFoundException;
import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.models.Livro;
import br.com.fuctura.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        throw new ObjectNotFoundException("Livro não Encontrado");
        //return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não Encontrada"));
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllLivrosByCategoria(id_cat);
    }

    public Livro save(Integer idCat, LivroDto livroDto) {
        livroDto.setId(null);
        Categoria cat = categoriaService.findById(idCat);
        livroDto.setCategoria(cat);
        return livroRepository.save(new Livro(livroDto));
    }

    public Livro update(Integer idCat, LivroDto livroDto) {

        findById(livroDto.getId());
        Categoria oldCategoria = categoriaService.findById(idCat);
        livroDto.setCategoria(oldCategoria);

        //Livro livro = new Livro(livroDto);

        return livroRepository.save(new Livro(livroDto));
    }

    public void delete(Integer id) {
        findById(id);
        livroRepository.deleteById(id);
    }

    public List<Livro> findAllLivrosByCategoriaName(String genero) {
        categoriaService.findByGenero(genero);
        return livroRepository.findByCategoriaGeneroContainingIgnoreCase(genero);
    }
}
