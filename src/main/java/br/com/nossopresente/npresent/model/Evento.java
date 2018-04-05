package br.com.nossopresente.npresent.model;

import br.com.nossopresente.npresent.type.TipoEventoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "evento")
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Enumerated
    @Column(name = "tipo")
    private TipoEventoEnum tipo;

    @Lob
    @Column(name = "imagem")
    private byte[] imagem;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id", nullable = false)
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "evento")
    private List<EventoProduto> eventoProdutos;

    public Evento() {
    }

    public Evento(String nome, TipoEventoEnum tipo, byte[] imagem, Fornecedor fornecedor) {
        this.nome = nome;
        this.tipo = tipo;
        this.imagem = imagem;
        this.fornecedor = fornecedor;
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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<EventoProduto> getEventoProdutos() {
        return eventoProdutos;
    }

    public void setEventoProdutos(List<EventoProduto> eventoProdutos) {
        this.eventoProdutos = eventoProdutos;
    }
}
