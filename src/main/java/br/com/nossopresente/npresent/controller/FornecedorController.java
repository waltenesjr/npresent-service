package br.com.nossopresente.npresent.controller;

import br.com.nossopresente.npresent.bean.FornecedorBean;
import br.com.nossopresente.npresent.model.Fornecedor;
import br.com.nossopresente.npresent.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<?> getAll() {
        List<FornecedorBean> resultList = service.getAll();
        try {
            return new ResponseEntity<>(resultList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<?> get(@PathVariable int id) {
        FornecedorBean result = service.get(id);
        try {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public void add(@RequestBody FornecedorBean bean) {
        service.add(bean);
    }
}
