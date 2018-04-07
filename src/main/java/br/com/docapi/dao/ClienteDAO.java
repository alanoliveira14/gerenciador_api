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

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "insert into cliente(nome, cnpj) values(?,?);";
            ps = conn.prepareStatement (sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCnpj());
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                ps.close();
                conn.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public List<ClienteEntity> listarClientes(){

        List<ClienteEntity> clientes = new ArrayList<ClienteEntity>();

        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "select * from cliente;";
            ps = conn.prepareStatement (sql);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while(rs.next()){
                ClienteEntity cliente = new ClienteEntity();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setCnpj(rs.getString(3));

                clientes.add(cliente);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return clientes;
    }

    public void deletaCliente(Integer idCliente){

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "delete from cliente where idcliente = ?";
            ps = conn.prepareStatement (sql);
            ps.setInt(1, idCliente);
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                ps.close();
                conn.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public void alterarCliente(ClienteEntity cliente){

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "update cliente set nome = ? where idcliente = ?";
            ps = conn.prepareStatement (sql);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getIdCliente());
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                ps.close();
                conn.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public ClienteEntity buscarCliente(String cnpjCliente){

        ClienteEntity cliente = new ClienteEntity();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "select * from cliente where cnpj = ?";
            ps = conn.prepareStatement (sql);
            ps.setString(1, cnpjCliente);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            if(rs.next()){

                cliente.setIdCliente(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setCnpj(rs.getString(3));

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return cliente;
    }

}

