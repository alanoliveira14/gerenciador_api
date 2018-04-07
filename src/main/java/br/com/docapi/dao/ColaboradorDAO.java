package br.com.docapi.dao;

import br.com.docapi.database.ConnectionFactory;
import br.com.docapi.entity.ColaboradorEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ColaboradorDAO {

    public void inserirColaborador(ColaboradorEntity colaborador){

        Connection conn = null;
        PreparedStatement ps = null;
        String retorno = "";
        String nome = null;
        Integer id = 0;

        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "insert into colaboradores(nome, email, dataNascimento, cpf) values(?,?,?,?);";
            ps = conn.prepareStatement (sql);
            ps.setString(1, colaborador.getNome());
            ps.setString(2, colaborador.getEmail());
            ps.setString(3, colaborador.getDataNascimento());
            ps.setString(4, colaborador.getCPF());
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

    public List<ColaboradorEntity> getColaboradores(){

        List<ColaboradorEntity> colaboradores = new ArrayList<ColaboradorEntity>();


        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "select * from colaboradores;";
            ps = conn.prepareStatement (sql);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while(rs.next()){
                ColaboradorEntity colab = new ColaboradorEntity();
                colab.setIdColaborador(rs.getInt(1));
                colab.setNome(rs.getString(2));
                colab.setEmail(rs.getString(3));
                colab.setDataNascimento(rs.getString(4));
                colab.setCPF(rs.getString(5));

                colaboradores.add(colab);
            }


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

        return colaboradores;
    }

    public void deletarColaborador(Integer idColaborador){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "delete from colaboradores where idColaboradores = ?";
            ps = conn.prepareStatement (sql);
            ps.setInt(1,idColaborador);
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

    public void alterarColaborador(ColaboradorEntity colaborador){
        Connection conn = null;
        PreparedStatement ps = null;
        String retorno = "";
        String nome = null;
        Integer id = 0;

        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "update colaboradores set nome = ?, email = ?, dataNascimento = ?, cpf = ? where idColaboradores = ?;";
            ps = conn.prepareStatement (sql);
            ps.setString(1, colaborador.getNome());
            ps.setString(2, colaborador.getEmail());
            ps.setString(3, colaborador.getDataNascimento());
            ps.setString(4, colaborador.getCPF());
            ps.setInt(5, colaborador.getIdColaborador());
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

    public ColaboradorEntity pesquisar(String cpf){

        ColaboradorEntity colab = new ColaboradorEntity();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = ConnectionFactory.obtemConexao();
            String sql = "select * from colaboradores where cpf = ?;";
            ps = conn.prepareStatement (sql);
            ps.setString(1, cpf);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            if(rs.next()){
                colab.setIdColaborador(rs.getInt(1));
                colab.setNome(rs.getString(2));
                colab.setEmail(rs.getString(3));
                colab.setDataNascimento(rs.getString(4));
                colab.setCPF(rs.getString(5));
            }


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

        return colab;
    }

}
