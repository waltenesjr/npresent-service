package br.com.nossopresente.npresent.service;

import br.com.nossopresente.npresent.bean.EventoBean;
import br.com.nossopresente.npresent.bean.ProdutoBean;
import br.com.nossopresente.npresent.builder.EventoBuilder;
import br.com.nossopresente.npresent.hibernate.HibernateDAO;
import br.com.nossopresente.npresent.model.Evento;
import br.com.nossopresente.npresent.model.EventoProduto;
import br.com.nossopresente.npresent.model.Fornecedor;
import br.com.nossopresente.npresent.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("eventoService")
public class EventoService {

    @Autowired
    private HibernateDAO dao;

    @Transactional
    public List<EventoBean> getAll() {
        List<EventoBean> list = new ArrayList<>();
        for (Evento e : (List<Evento>) dao.createCriteria(Evento.class).list()) {
            list.add(EventoBuilder.modelToBean(e));
        }
        return list;
    }

    @Transactional
    public EventoBean get(int id) {
        return EventoBuilder.modelToBean((Evento) dao.get(Evento.class, id));
    }

    @Transactional
    public void add(EventoBean bean) {
        Evento e = EventoBuilder.beanToModel(bean, (Fornecedor) dao.get(Fornecedor.class, bean.getFornecedor()));
        dao.persist(e);
        addProdutos(bean.getProdutos(), e);
    }

    private void addProdutos(List<ProdutoBean> listBean, Evento e) {
        for (ProdutoBean bean : listBean) {
            dao.persist(new EventoProduto(e, (Produto) dao.get(Produto.class, bean.getId())));
        }
    }
}
