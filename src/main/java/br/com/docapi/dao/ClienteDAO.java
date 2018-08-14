package br.com.docapi.dao;

import br.com.docapi.database.ConnectionFactory;
import br.com.docapi.entity.ClienteEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteDAO {

    public void inserirCliente(ClienteEntity cliente){

        String sql = "insert into cliente(nome, cnpj) values(?,?);";

        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement (sql);
        ){
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCnpj());
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<ClienteEntity> listarClientes(){

        List<ClienteEntity> clientes = new ArrayList<ClienteEntity>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "select * from cliente;";
            ps = conn.prepareStatement (sql);
            ps.execute();
            rs = ps.getResultSet();

            while(rs.next()){
                ClienteEntity cliente = new ClienteEntity();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setCnpj(rs.getString(3));

                clientes.add(cliente);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return clientes;
    }

    public void deletaCliente(Integer idCliente){

        String sql = "delete from cliente where idcliente = ?";


        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement (sql);
        ){
            ps.setInt(1, idCliente);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void alterarCliente(ClienteEntity cliente){

        String sql = "update cliente set nome = ? where idcliente = ?";

        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement (sql);
        ){


            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getIdCliente());
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ClienteEntity buscarCliente(String cnpjCliente){

        ClienteEntity cliente = new ClienteEntity();
        String sql = "select * from cliente where cnpj = ?";

        try(Connection  conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement (sql);
        ){
            ps.setString(1, cnpjCliente);
            ps.execute();

            try(ResultSet rs = ps.getResultSet();){
                if(rs.next()){

                    cliente.setIdCliente(rs.getInt(1));
                    cliente.setNome(rs.getString(2));
                    cliente.setCnpj(rs.getString(3));

                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return cliente;
    }

}

