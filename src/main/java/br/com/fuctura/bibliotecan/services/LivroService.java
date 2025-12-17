package br.com.fuctura.bibliotecan.services;

import br.com.fuctura.bibliotecan.dtos.LivroDto;
import br.com.fuctura.bibliotecan.exceptions.ObjectNotFoundException;
import br.com.fuctura.bibliotecan.models.Categoria;
import br.com.fuctura.bibliotecan.models.Livro;
import br.com.fuctura.bibliotecan.repositories.LivroRepository;
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
        if (livroRepository.findById(id).isPresent()) {
            return livro.get();
        }
        throw new ObjectNotFoundException("Livro não encontrado com o ID: " + id);
    }

    public List<Livro> findAll(Integer idCat) {
        categoriaService.findById(idCat);
        return livroRepository.findAllByCategoriaId(idCat);
    }

    public Livro save(Integer idCat, LivroDto livroDto) {
        livroDto.setId(null);
        Categoria categoria = categoriaService.findById(idCat);
        livroDto.setCategoria(categoria);
        return livroRepository.save(new Livro(livroDto));
    }

    public Livro update(Integer idCat, LivroDto livroDto) {
        findById(livroDto.getId());
        Categoria categoria = categoriaService.findById(idCat);
        livroDto.setCategoria(categoria);
        return livroRepository.save(new Livro(livroDto));
    }
}
