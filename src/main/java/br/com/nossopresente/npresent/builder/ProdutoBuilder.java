package br.com.nossopresente.npresent.builder;

import br.com.nossopresente.npresent.bean.ProdutoBean;
import br.com.nossopresente.npresent.model.EventoProduto;
import br.com.nossopresente.npresent.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoBuilder {

    public static Produto beanToModel(ProdutoBean bean) {
        return new Produto(bean.getId(), bean.getNome(), bean.getLink(), bean.getValor(), bean.getCategoria());
    }

    public static ProdutoBean modelToBean(Produto model) {
        return new ProdutoBean(model.getId(), model.getNome(), model.getLink(), model.getValor(), model.getCategoria());
    }

    public static List<ProdutoBean> listModelToListBean(List<EventoProduto> listModel) {
        List<ProdutoBean> listBean = new ArrayList<>();
        for (EventoProduto ep : listModel) {
            listBean.add(modelToBean(ep.getProduto()));
        }
        return listBean;
    }
}
