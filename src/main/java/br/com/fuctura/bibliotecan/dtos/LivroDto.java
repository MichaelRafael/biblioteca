package br.com.fuctura.bibliotecan.dtos;

import br.com.fuctura.bibliotecan.enums.Edicao;
import br.com.fuctura.bibliotecan.models.Categoria;
import br.com.fuctura.bibliotecan.models.Livro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class LivroDto {

    private Integer id;
    private String titulo;
    private String autor;
    private String texto;
    private Edicao edicao;
    private Categoria categoria;

    public LivroDto() {
    }

    public LivroDto(Integer id, String titulo, String autor, String texto, Edicao edicao, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.edicao = edicao;
        this.categoria = categoria;
    }

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.texto = livro.getTexto();
        this.edicao = livro.getEdicao();
        this.categoria = livro.getCategoria();
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

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
