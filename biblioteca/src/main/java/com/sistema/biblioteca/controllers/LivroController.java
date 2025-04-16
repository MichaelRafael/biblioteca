package com.sistema.biblioteca.controllers;

import com.sistema.biblioteca.dtos.LivroDTO;
import com.sistema.biblioteca.models.Livro;
import com.sistema.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDTO(livro));
    }

    //localhost:8081/livro?categoria=1
    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer categoriaId) {
        List<Livro> list = livroService.findAll(categoriaId);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));

    }

    @GetMapping("/categoria/{nome}")
    public ResponseEntity<List<LivroDTO>> findByCategoriaNome(@PathVariable String nome) {
        List<Livro> list = livroService.findByCategoriaNome(nome);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));
    }

    //localhost:8081/livro?categoria=1
    @PostMapping
    public ResponseEntity<LivroDTO> save(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
                                         @RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.save(id_cat, livroDTO);
        return ResponseEntity.ok().body(new LivroDTO(livro));

    }

    //localhost:8081/livro/2?categoria=1
    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Integer id,
                                           @RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
                                           @RequestBody LivroDTO livroDTO) {
        livroDTO.setId(id);
        Livro livro = livroService.update(id_cat, livroDTO);
        return ResponseEntity.ok().body(new LivroDTO(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
