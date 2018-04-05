package br.com.nossopresente.npresent.builder;

import br.com.nossopresente.npresent.bean.EventoBean;
import br.com.nossopresente.npresent.model.Evento;
import br.com.nossopresente.npresent.model.Fornecedor;

import java.util.Base64;

public class EventoBuilder {

    public static Evento beanToModel(EventoBean bean, Fornecedor fornecedor) {
        return new Evento(bean.getNome(), bean.getTipo(), Base64.getDecoder().decode(bean.getImagem()), fornecedor);
    }

    public static EventoBean modelToBean(Evento model) {
        return new EventoBean(model.getId(), model.getNome(), model.getTipo(), model.getFornecedor().getId(), Base64.getEncoder().encodeToString(model.getImagem()), ProdutoBuilder.listModelToListBean(model.getEventoProdutos()));
    }
}
