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

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "evento")
    private List<EventoProduto> eventoProdutos;

    public Evento() {
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
