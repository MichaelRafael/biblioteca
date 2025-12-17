package br.com.fuctura.bibliotecan.controllers.impl;

import br.com.fuctura.bibliotecan.dtos.LivroDto;
import br.com.fuctura.bibliotecan.models.Livro;
import br.com.fuctura.bibliotecan.services.LivroService;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroControllerImpl {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    //localhost:8080/livro?categoria=

    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
        List<Livro> list = livroService.findAll(id_cat);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<LivroDto> save(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
                                         @RequestBody LivroDto livroDto) {
        Livro livro = livroService.save(id_cat, livroDto);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> update(@PathVariable Integer id,
                                           @RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
                                           @RequestBody LivroDto livroDto) {
        livroDto.setId(id);
        Livro livro = livroService.update(id_cat, livroDto);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

}
