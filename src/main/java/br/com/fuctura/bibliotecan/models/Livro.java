package br.com.fuctura.bibliotecan.models;

import br.com.fuctura.bibliotecan.dtos.LivroDto;
import br.com.fuctura.bibliotecan.enums.Edicao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;

    private String autor;
    private String texto;
    private Edicao edicao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro() {}

    public Livro(Integer id, String titulo, String autor, String texto, Edicao edicao, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.edicao = edicao;
        this.categoria = categoria;
    }

    public Livro(LivroDto livroDto) {
        this.id = livroDto.getId();
        this.titulo = livroDto.getTitulo();
        this.autor = livroDto.getAutor();
        this.texto = livroDto.getTexto();
        this.edicao = livroDto.getEdicao();
        this.categoria = livroDto.getCategoria();
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
