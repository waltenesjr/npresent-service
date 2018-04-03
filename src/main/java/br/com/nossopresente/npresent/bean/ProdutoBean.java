package br.com.nossopresente.npresent.bean;

import br.com.nossopresente.npresent.type.CategoriaProdutoEnum;

public class ProdutoBean {

    private int id;
    private String nome;
    private String link;
    private Float valor;
    private CategoriaProdutoEnum categoria;

    public ProdutoBean() {
    }

    public ProdutoBean(int id, String nome, String link, Float valor, CategoriaProdutoEnum categoria) {
        this.id = id;
        this.nome = nome;
        this.link = link;
        this.valor = valor;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public CategoriaProdutoEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProdutoEnum categoria) {
        this.categoria = categoria;
    }
}
