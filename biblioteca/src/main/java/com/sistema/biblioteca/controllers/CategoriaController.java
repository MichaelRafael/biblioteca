package com.sistema.biblioteca.controllers;

import com.sistema.biblioteca.dtos.CategoriaDTO;
import com.sistema.biblioteca.models.Categoria;
import com.sistema.biblioteca.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    //localhost:8080/categoria
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list.stream().map(categoria -> modelMapper.map(categoria, CategoriaDTO.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@Valid @RequestBody CategoriaDTO categoriaDTO)  {
        categoriaDTO.setId(null);
        Categoria cat = categoriaService.save(modelMapper.map(categoriaDTO, Categoria.class));
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id,@Valid @RequestBody CategoriaDTO categoriaDTO) {
        categoriaDTO.setId(id);
        Categoria cat = categoriaService.update(modelMapper.map(categoriaDTO, Categoria.class));
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
