package br.com.nossopresente.npresent.service;

import br.com.nossopresente.npresent.bean.FornecedorBean;
import br.com.nossopresente.npresent.builder.FornecedorBuilder;
import br.com.nossopresente.npresent.hibernate.HibernateDAO;
import br.com.nossopresente.npresent.model.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("fornecedorService")
public class FornecedorService {

    @Autowired
    private HibernateDAO dao;

    @Transactional
    public List<FornecedorBean> getAll() {
        List<FornecedorBean> list = new ArrayList<>();
        for (Fornecedor f : (List<Fornecedor>) dao.createCriteria(Fornecedor.class).list()) {
            list.add(FornecedorBuilder.modelToBean(f));
        }
        return list;
    }

    @Transactional
    public FornecedorBean get(int id) {
        return FornecedorBuilder.modelToBean((Fornecedor) dao.get(Fornecedor.class, id));
    }

    @Transactional
    public void add(FornecedorBean bean) {
        dao.persist(FornecedorBuilder.beanToModel(bean));
    }

    @Transactional
    public String getLinkLoja(int id) {
        Fornecedor f = (Fornecedor) dao.get(Fornecedor.class, id);
        int pos = f.getLoja().indexOf("?");
        return f.getLoja().substring(pos, f.getLoja().length());
    }
}
