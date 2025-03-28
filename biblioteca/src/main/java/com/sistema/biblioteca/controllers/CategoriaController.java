package com.sistema.biblioteca.controllers;

import com.sistema.biblioteca.models.Categoria;
import com.sistema.biblioteca.services.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    //localhost:8080/categoria
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        return cat;
    }

    @GetMapping
    public List<Categoria> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return list;
    }

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria) {
        Categoria cat = categoriaService.save(categoria);
        return cat;
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        Categoria cat = categoriaService.update(categoria);
        return cat;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoriaService.delete(id);
    }

}
