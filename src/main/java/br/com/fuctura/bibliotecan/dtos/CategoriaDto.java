package br.com.fuctura.bibliotecan.dtos;


import br.com.fuctura.bibliotecan.models.Categoria;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class CategoriaDto {

    private Integer id;

    @NotNull(message = "O campo nome não pode ser nulo.")
    @Length(min = 5, max = 15, message = "O campo nome deve ter entre 5 e 15 caracteres.")
    private String nome;

    @NotNull(message = "O campo descrição não pode ser nulo.")
    @Length(min = 5, max = 25, message = "O campo descrição deve ter entre 5 e 25 caracteres.")
    private String descricao;

    public CategoriaDto() {
    }

    public CategoriaDto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
    public CategoriaDto(Categoria cat) {
        this.id = cat.getId();
        this.nome = cat.getNome();
        this.descricao = cat.getDescricao();
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
