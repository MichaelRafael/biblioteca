package com.sistema.biblioteca.dtos;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    private Integer id;
    @NotBlank(message = "Campo nome é obrigatório")
    @Length(min = 3, max = 20, message = "Campo nome deve ter entre 3 e 20 caracteres")
    private String nome;
    @NotBlank(message = "Campo descrição é obrigatório")
    @Length(min = 20, max = 50, message = "Campo descrição deve ter entre 20 e 50 caracteres")
    private String descricao;


    public CategoriaDTO() {
    }

    public CategoriaDTO(Integer id, String nome, String descricao) {
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


}
