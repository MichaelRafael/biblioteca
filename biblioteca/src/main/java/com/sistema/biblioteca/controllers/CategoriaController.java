package com.sistema.biblioteca.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @GetMapping
    public String test() {
        return "Testefdyhrtu6yui7ydfgrsdgertgr4";
    }
}
