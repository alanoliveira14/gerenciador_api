package br.com.docapi.dao;

import br.com.docapi.entity.ProjetoEntity;
import br.com.docapi.database.ConnectionFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class ProjetoDAO {

    public void inserirProjeto(ProjetoEntity projeto) {

        String sql = "insert into projetos(titulo, descricao, fkIdGerente, finalidade, fkIdCliente) values(?,?,?,?,?);";

        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement (sql);
        ){
            ps.setString(1, projeto.getTitulo());
            ps.setString(2, projeto.getDescricao());
            ps.setInt(3,    projeto.getIdGerente());
            ps.setString(4, projeto.getFinalidade());
            ps.setInt(5,    projeto.getIdCliente());

            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<ProjetoEntity> listarProjetos() {

        List<ProjetoEntity> projetos = new ArrayList<ProjetoEntity>();

        String sql = "select p.idprojetos, p.titulo, p.descricao, p.fkIdGerente, col.nome, p.finalidade, p.fkIdCliente, cli.nome from projetos p, cliente cli, colaboradores col where p.fkIdCliente = cli.idcliente and p.fkIdGerente = col.idcolaboradores;";

        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
        ){

            ps.execute();

            try(ResultSet rs = ps.getResultSet();){

                while (rs.next()) {
                    ProjetoEntity projeto = new ProjetoEntity();
                    projeto.setIdProjeto(rs.getInt(1));
                    projeto.setTitulo(rs.getString(2));
                    projeto.setDescricao(rs.getString(3));
                    projeto.setIdGerente(rs.getInt(4));
                    projeto.setNomeGerente(rs.getString(5));
                    projeto.setFinalidade(rs.getString(6));
                    projeto.setIdCliente(rs.getInt(7));
                    projeto.setNomeCliente(rs.getString(8));

                    projetos.add(projeto);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projetos;
    }

    public void deletaProjeto(Integer idProjeto) {

        String sql = "delete from projetos where idprojetos = ?";

        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){


            ps.setInt(1, idProjeto);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarProjeto(ProjetoEntity cliente) {



    }

    public ProjetoEntity buscarProjeto(String tituloProjeto) {

        ProjetoEntity projeto = new ProjetoEntity();
        String sql = "select p.idprojetos, p.titulo, p.descricao, p.fkIdGerente, col.nome, p.finalidade, p.fkIdCliente, cli.nome from projetos p, cliente cli, colaboradores col where p.fkIdCliente = cli.idcliente and p.fkIdGerente = col.idcolaboradores and p.titulo = ?";

        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){

            ps.setString(1, tituloProjeto);
            ps.execute();
            try(ResultSet rs = ps.getResultSet();){

                if (rs.next()) {

                    projeto.setIdProjeto(rs.getInt(1));
                    projeto.setTitulo(rs.getString(2));
                    projeto.setDescricao(rs.getString(3));
                    projeto.setIdGerente(rs.getInt(4));
                    projeto.setNomeGerente(rs.getString(5));
                    projeto.setFinalidade(rs.getString(6));
                    projeto.setIdCliente(rs.getInt(7));
                    projeto.setNomeCliente(rs.getString(8));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projeto;
    }
}