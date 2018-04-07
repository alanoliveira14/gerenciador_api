package br.com.docapi.controllers;

import br.com.docapi.ResultadoOperacaoAPI;
import br.com.docapi.entity.ClienteEntity;
import br.com.docapi.models.ClienteModel;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteModel clienteModel ;

    @RequestMapping(value = "/criar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI inserir(@RequestBody ClienteEntity cliente) throws Exception{

        try{
            clienteModel.cadastrarCliente(cliente);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(),false);
        }

        return new ResultadoOperacaoAPI("Inserido com sucesso",true);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<List<ClienteEntity>> listar() throws Exception{

        List<ClienteEntity> clientes = null;

        try{
            clientes = clienteModel.listarClientes();
        }
        catch (Exception e){
            return new ResponseEntity<List<ClienteEntity>>(clientes,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<ClienteEntity>>(clientes,HttpStatus.OK);
    }

    @RequestMapping(value = "/deletar/{idCliente}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI delatar(@PathVariable Integer idCliente) throws Exception{

        try{
            clienteModel.deleteCliente(idCliente);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(),false);
        }

        return new ResultadoOperacaoAPI("Deletado com sucesso",true);
    }

    @RequestMapping(value = "/alterar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResultadoOperacaoAPI alterar(@RequestBody ClienteEntity cliente) throws Exception{

        try{
            clienteModel.alteraCliente(cliente);
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(),false);
        }

        return new ResultadoOperacaoAPI("Alterado com sucesso",true);
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Object buscar(@RequestBody ClienteEntity cli) throws Exception{

        ClienteEntity cliente = null;
        try{
            cliente = clienteModel.buscaCliente(cli.getCnpj());
        }
        catch (Exception e){
            return new ResultadoOperacaoAPI(e.getMessage(),false);
        }

        return cliente;
    }


}
