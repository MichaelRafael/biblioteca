package com.fuctura.biblioteca.services;

import com.fuctura.biblioteca.dtos.CategoriaDto;
import com.fuctura.biblioteca.exceptions.IllegalArgumentException;
import com.fuctura.biblioteca.exceptions.ObjectNotFoundException;
import com.fuctura.biblioteca.models.Categoria;
import com.fuctura.biblioteca.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Categoria findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if (cat.isPresent()) {
            return cat.get();
        }

        throw new ObjectNotFoundException("Categoria não encontrada!");
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(CategoriaDto categoriaDto) {
        findByNome(categoriaDto);
        categoriaDto.setId(null);
        return categoriaRepository.save(modelMapper.map(categoriaDto, Categoria.class));
    }

    private void findByNome(CategoriaDto categoriaDto) {
        Optional<Categoria> cat = categoriaRepository.findByNome(categoriaDto.getNome());
        if (cat.isPresent() && cat.get().getNome().equals(categoriaDto.getNome())) {
            throw new IllegalArgumentException("Já existe uma categoria com este nome: " + categoriaDto.getNome());
        }
    }
}
