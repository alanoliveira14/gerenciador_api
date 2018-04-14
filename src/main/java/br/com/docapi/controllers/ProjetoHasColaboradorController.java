package br.com.docapi.controllers;

import br.com.docapi.ResultadoOperacaoAPI;
import br.com.docapi.entity.ColaboradorEntity;
import br.com.docapi.entity.ProjetoHasColaboradoresEntity;
import br.com.docapi.models.ColaboradorModel;
import br.com.docapi.models.ProjetoHasColaboradoresModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/projetoColab")
public class ProjetoHasColaboradorController {
    @Autowired
    private ProjetoHasColaboradoresModel projetoColabModel ;

    @RequestMapping(value = "/inserir", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI inserir(@RequestBody ProjetoHasColaboradoresEntity projetoColab) throws Exception{


        try{
            projetoColabModel.inserirColaboradorProjeto(projetoColab);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(),false);
        }

        return new ResultadoOperacaoAPI("Inserido com sucesso",true);
    }


}
