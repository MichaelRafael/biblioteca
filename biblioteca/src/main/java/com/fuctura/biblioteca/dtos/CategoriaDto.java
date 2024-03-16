package com.fuctura.biblioteca.dtos;

import com.fuctura.biblioteca.models.Livro;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDto {

    private Integer id;
    private String nome;
    private String descricao;
    //private List<Livro> livros = new ArrayList<>();

    public CategoriaDto() {
    }

    public CategoriaDto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

//    public List<Livro> getLivros() {
//        return livros;
//    }
//
//    public void setLivros(List<Livro> livros) {
//        this.livros = livros;
//    }
}
