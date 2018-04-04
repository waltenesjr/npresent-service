package br.com.nossopresente.npresent.builder;

import br.com.nossopresente.npresent.bean.FornecedorBean;
import br.com.nossopresente.npresent.model.Fornecedor;

import java.util.Base64;

public class FornecedorBuilder {

    public static Fornecedor beanToModel(FornecedorBean bean) {
        return new Fornecedor(bean.getId(), bean.getNome(), bean.getEmail(), bean.getLoja(), Base64.getDecoder().decode(bean.getImagem()));
    }

    public static FornecedorBean modelToBean(Fornecedor model) {
        return new FornecedorBean(model.getId(), model.getNome(), model.getEmail(), model.getLoja(), Base64.getEncoder().encodeToString(model.getImagem()));
    }
}
