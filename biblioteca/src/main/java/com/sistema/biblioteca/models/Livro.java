package com.sistema.biblioteca.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.biblioteca.dtos.LivroDTO;
import com.sistema.biblioteca.enums.Tamanho;
import javax.persistence.*;


@Entity
@Table(name = "tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String autor;
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private Tamanho tamanho;

    public Livro() {
    }

    public Livro(Integer id, String titulo, String autor, String texto, Tamanho tamanho, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.categoria = categoria;
        this.tamanho = tamanho;
    }

    public Livro(LivroDTO livroDTO) {
        this.id = livroDTO.getId();
        this.titulo = livroDTO.getTitulo();
        this.autor = livroDTO.getAutor();
        this.texto = livroDTO.getTexto();
        this.categoria = livroDTO.getCategoria();
        this.tamanho = livroDTO.getTamanho();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }
}
