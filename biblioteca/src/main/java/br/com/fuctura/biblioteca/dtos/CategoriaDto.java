package br.com.fuctura.biblioteca.dtos;
import br.com.fuctura.biblioteca.models.Livro;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDto {

    private Integer id;
    private String genero;
    private String descricao;


    public CategoriaDto() {
    }

    public CategoriaDto(Integer id, String genero, String descricao) {
        this.id = id;
        this.genero = genero;
        this.descricao = descricao;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
