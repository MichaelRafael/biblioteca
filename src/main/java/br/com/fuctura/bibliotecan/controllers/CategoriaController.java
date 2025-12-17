package br.com.fuctura.bibliotecan.controllers;

import br.com.fuctura.bibliotecan.dtos.CategoriaDto;
import br.com.fuctura.bibliotecan.models.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoriaController {

    ResponseEntity<CategoriaDto> findById(Integer id);
    ResponseEntity<List<CategoriaDto>> findAll();
    ResponseEntity<CategoriaDto> save(CategoriaDto categoriaDto);
    ResponseEntity<CategoriaDto> update(Integer id, CategoriaDto categoriaDto);
    ResponseEntity<Void> delete(Integer id);
}
