package br.com.nossopresente.npresent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "evento_produto")
public class EventoProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_evento", referencedColumnName = "id", nullable = false)
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id", nullable = false)
    private Produto produto;

    public EventoProduto() {
    }

    public EventoProduto(Evento evento, Produto produto) {
        this.evento = evento;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
