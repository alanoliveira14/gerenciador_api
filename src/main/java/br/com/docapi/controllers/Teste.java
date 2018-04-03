package br.com.docapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.docapi.dao.TesteDAO;
import br.com.docapi.entity.TesteEntity;
import br.com.docapi.models.TesteModel;

@Controller
public class Teste {
    @Autowired
    private TesteModel testeModel;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/testar", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<TesteEntity> teste() throws Exception{
        TesteEntity teste1 = new TesteEntity();
        teste1 = testeModel.teste();

        return new ResponseEntity<TesteEntity>(teste1, HttpStatus.OK);
    }


}
