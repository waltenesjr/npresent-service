package br.com.nossopresente.npresent.bean;

import br.com.nossopresente.npresent.type.TipoEventoEnum;

import java.util.List;

public class EventoBean {

    private int id;
    private String nome;
    private TipoEventoEnum tipo;
    private int fornecedor;
    private String imagem;
    private List<ProdutoBean> produtos;

    public EventoBean() {
    }

    public EventoBean(int id, String nome, TipoEventoEnum tipo, int fornecedor, String imagem, List<ProdutoBean> produtos) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.fornecedor = fornecedor;
        this.imagem = imagem;
        this.produtos = produtos;
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

    public TipoEventoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEventoEnum tipo) {
        this.tipo = tipo;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<ProdutoBean> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoBean> produtos) {
        this.produtos = produtos;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
