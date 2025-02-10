package br.com.fuctura.biblioteca.dtos;
import br.com.fuctura.biblioteca.models.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDto {

    private Integer id;

    @Length(min = 3, max = 20, message = "Mínimo de 3 caracteres e máximo de 20")
    @NotBlank(message = "O campo NOME é requerido")
    private String genero;

    @Length(min = 30, max = 50, message = "Mínimo de 30 caracteres e máximo de 50")
    @NotBlank(message = "O campo DESCRIÇÃO é requerido")
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
