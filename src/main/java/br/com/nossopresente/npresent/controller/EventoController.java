package br.com.nossopresente.npresent.controller;

import br.com.nossopresente.npresent.bean.EventoBean;
import br.com.nossopresente.npresent.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("evento")
public class EventoController {

    @Autowired
    EventoService service;

    @RequestMapping(value = "all", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    ResponseEntity<?> get(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.get(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "get-evento-fornecedor", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    ResponseEntity<?> get(@RequestParam(value = "nome") String nome, @RequestParam(value = "fornecedor") int fornecedor) {
        try {
            return new ResponseEntity<>(service.findByNomeAndFornecedor(nome, fornecedor), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "add", method = RequestMethod.POST, headers = "Accept=application/json")
    public void add(@RequestBody EventoBean bean) {
        service.add(bean);
    }
}
