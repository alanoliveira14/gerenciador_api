package br.com.docapi.models;

import br.com.docapi.entity.ClienteEntity;
import br.com.docapi.dao.ClienteDAO;
import br.com.docapi.database.ConnectionFactory;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ClienteModel {

    ClienteDAO clienteDAO = new ClienteDAO();

    public void cadastrarCliente(ClienteEntity cliente){
        clienteDAO.inserirCliente(cliente);
    }

    public List<ClienteEntity> listarClientes(){
        return clienteDAO.listarClientes();
    }

    public void deleteCliente(Integer idCliente){
        clienteDAO.deletaCliente(idCliente);
    }

    public void alteraCliente(ClienteEntity cliente){
        clienteDAO.alterarCliente(cliente);
    }

    public ClienteEntity buscaCliente(java.lang.String cnpjCliente){
        return clienteDAO.buscarCliente(cnpjCliente);
    }


}
