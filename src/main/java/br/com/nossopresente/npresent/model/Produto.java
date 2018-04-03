package br.com.nossopresente.npresent.model;

import br.com.nossopresente.npresent.type.CategoriaProdutoEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "link")
    private String link;

    @Column(name = "valor")
    private Float valor;

    @Enumerated
    @Column(name = "categoria")
    private CategoriaProdutoEnum categoria;

    public Produto() {
    }

    public Produto(int id, String nome, String link, Float valor, CategoriaProdutoEnum categoria) {
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
