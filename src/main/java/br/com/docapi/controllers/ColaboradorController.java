package br.com.docapi.controllers;

import br.com.docapi.ResultadoOperacaoAPI;
import br.com.docapi.entity.ColaboradorEntity;
import br.com.docapi.models.ColaboradorModel;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<List<ColaboradorEntity>> colaboradores() throws Exception{

        List<ColaboradorEntity> colaboradores = null;

        try{
            colaboradores = colaboradorModel.getColaboradores();
        }
        catch (Exception e){
            return new ResponseEntity<List<ColaboradorEntity>>(colaboradores, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<ColaboradorEntity>>(colaboradores, HttpStatus.OK);
    }
    @RequestMapping(value = "/deletar/{idColaborador}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI deletar(@PathVariable Integer idColaborador) throws Exception{

        try{
            colaboradorModel.deletarColaborador(idColaborador);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(), false);
        }

        return new ResultadoOperacaoAPI("Deletado com sucesso", true);
    }

    @RequestMapping(value = "/alterar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI alterar(@RequestBody ColaboradorEntity colaborador) throws Exception{

        try{
            colaboradorModel.alterarColaborador(colaborador);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(), false);
        }

        return new ResultadoOperacaoAPI("Alterado com sucesso!", true);
    }
    @RequestMapping(value = "/pesquisar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<ColaboradorEntity> pesquisar(@RequestBody ColaboradorEntity colab) throws Exception{

        ColaboradorEntity colaborador = null;
        try{
            colaborador = colaboradorModel.pesquisar(colab.getCPF());
        }
        catch (Exception e){
            return new ResponseEntity<ColaboradorEntity>(colaborador, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ColaboradorEntity>(colaborador, HttpStatus.OK);
    }

}
