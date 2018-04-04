package br.com.docapi.controllers;

import br.com.docapi.entity.ColaboradorEntity;
import br.com.docapi.models.ColaboradorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/colaborador")
public class ColaboradorController {
    @Autowired
    private ColaboradorModel colaboradorModel ;

    @RequestMapping(value = "/criar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String inserir(@RequestBody ColaboradorEntity colaborador) throws Exception{

        try{
            colaboradorModel.cadastrarColaborador(colaborador);
        }
        catch (Exception e){
            return e.getMessage();
        }

        return "Inserido com sucesso!";
    }

}
