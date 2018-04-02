package br.com.nossopresente.npresent.service;

import br.com.nossopresente.npresent.bean.FornecedorBean;
import br.com.nossopresente.npresent.hibernate.HibernateDAO;
import br.com.nossopresente.npresent.model.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service("fornecedorService")
public class FornecedorService {

    @Autowired
    private HibernateDAO dao;

    @Transactional
    public List<FornecedorBean> getAll() {
        List<FornecedorBean> list = new ArrayList<>();
        for (Fornecedor f : (List<Fornecedor>) dao.createCriteria(Fornecedor.class).list()) {
            list.add(modelToBean(f));
        }
        return list;
    }

    @Transactional
    public FornecedorBean get(int id) {
        return modelToBean((Fornecedor) dao.get(Fornecedor.class, id));
    }

    @Transactional
    public void add(FornecedorBean bean) {
        dao.persist(beanToModel(bean));
    }

    private Fornecedor beanToModel(FornecedorBean bean) {
        return new Fornecedor(bean.getId(), bean.getNome(), bean.getEmail(), bean.getLoja(), Base64.getDecoder().decode(bean.getImagem()));
    }

    private FornecedorBean modelToBean(Fornecedor model) {
        return new FornecedorBean(model.getId(), model.getNome(), model.getEmail(), model.getLoja(), Base64.getEncoder().encodeToString(model.getImagem()));
    }
}
