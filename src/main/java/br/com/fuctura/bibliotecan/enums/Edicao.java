package br.com.fuctura.bibliotecan.enums;

public enum Edicao {

    PRIMEIRA(0),
    SEGUNDA(1),
    TERCEIRA(2);

    private final int codigo;

    private Edicao(int cod) {
        this.codigo = cod;
    }
}
