package br.com.docapi.controllers;

import br.com.docapi.ResultadoOperacaoAPI;
import br.com.docapi.entity.ClienteEntity;
import br.com.docapi.entity.ProjetoEntity;
import br.com.docapi.models.ProjetoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoModel projetoModel ;

    @RequestMapping(value = "/criar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI inserir(@RequestBody ProjetoEntity projeto) throws Exception{

        try{
            projetoModel.cadastrarProjeto(projeto);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(),false);
        }

        return new ResultadoOperacaoAPI("Inserido com sucesso",true);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<List<ProjetoEntity>> listar() throws Exception{

        List<ProjetoEntity> projetos = null;

        try{
            projetos = projetoModel.listarProjetos();
        }
        catch (Exception e){
            return new ResponseEntity<List<ProjetoEntity>>(projetos,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<ProjetoEntity>>(projetos,HttpStatus.OK);
    }

    @RequestMapping(value = "/deletar/{idProjeto}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI delatar(@PathVariable Integer idProjeto) throws Exception{

        try{
            projetoModel.deleteProjeto(idProjeto);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(),false);
        }

        return new ResultadoOperacaoAPI("Deletado com sucesso",true);
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<ProjetoEntity> buscar(@RequestBody ProjetoEntity proj) throws Exception{

        ProjetoEntity projeto = null;
        try{
            projeto = projetoModel.buscaProjeto(proj.getTitulo());
        }
        catch (Exception e){
            return new ResponseEntity<ProjetoEntity>(projeto, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ProjetoEntity>(projeto, HttpStatus.OK);
    }


}
