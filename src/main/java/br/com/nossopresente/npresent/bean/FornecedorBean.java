package br.com.nossopresente.npresent.bean;

public class FornecedorBean {

    private int id;
    private String nome;
    private String email;
    private String loja;
    private String imagem;

    public FornecedorBean() {
    }

    public FornecedorBean(int id, String nome, String email, String loja, String imagem) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.loja = loja;
        this.imagem = imagem;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
