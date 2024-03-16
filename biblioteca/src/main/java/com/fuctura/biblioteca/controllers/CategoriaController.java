package com.fuctura.biblioteca.controllers;

import com.fuctura.biblioteca.dtos.CategoriaDto;
import com.fuctura.biblioteca.models.Categoria;
import com.fuctura.biblioteca.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    //@GetMapping("/{id}") = findById(id);
    //@GetMapping = findAll;
    //@PostMapping = save;
    //@PutMapping = atualizar;
    //@DeleteMapping = deletar;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> modelMapper.map(obj, CategoriaDto.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> save(@RequestBody CategoriaDto categoriaDto) {
        Categoria cat = categoriaService.save(categoriaDto);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }
}
