package br.com.docapi.dao;
import br.com.docapi.database.ConnectionFactory;
import br.com.docapi.entity.TarefaEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TarefaDAO {


    public void inserirTarefa(TarefaEntity tarefa){

        String sql = "insert into tarefas(descricao,dataInicio, dataPrevista, situacao, fkIdProjeto,fkIdColaborador) values(?,?,?,?,?,?);";

        try(
                Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement ps = conn.prepareStatement (sql);
        ){
            ps.setString(1, tarefa.getDescricao());
            ps.setString(2, tarefa.getDataInicio());
            ps.setString(3, tarefa.getDataPrevista());
            ps.setString(4, tarefa.getSituacao());
            ps.setInt(5, tarefa.getFkIdProjeto());
            ps.setInt(6, tarefa.getFkIdColaborador());
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void alterarTarefa(TarefaEntity tarefa){

        if (tarefa.getDataFinalizacao() == null){

            String sql = "update tarefas set situacao = ?, fkIdColaborador = ? where idTarefas = ?;";

            try(
                    Connection conn = ConnectionFactory.obtemConexao();
                    PreparedStatement ps = conn.prepareStatement (sql);
            ){


                ps.setString(1, tarefa.getSituacao());
                ps.setInt(2, tarefa.getFkIdColaborador());
                ps.setInt(3, tarefa.getIdTarefas());
                ps.execute();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }else{
            String sql = "update tarefas set situacao = ?,  fkIdColaborador = ?, dataFinalizacao = ? where idTarefas = ?;";
            try(
                Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement ps = conn.prepareStatement (sql);
            ){
                ps.setString(1, tarefa.getSituacao());
                ps.setInt(2, tarefa.getFkIdColaborador());
                ps.setString(3, tarefa.getDataFinalizacao());
                ps.setInt(4, tarefa.getIdTarefas());
                ps.execute();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public List<TarefaEntity> listarTarefas() {

        List<TarefaEntity> tarefas = new ArrayList<TarefaEntity>();

        String sql = "select tarefas.*, c.nome, p.titulo from tarefas inner join colaboradores as c inner join projetos as p where c.idcolaboradores = tarefas.fkIdColaborador and p.idprojetos = tarefas.fkIdProjeto;;";

        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){


            ps.execute();

            try(ResultSet rs = ps.getResultSet();){

                while (rs.next()) {
                    TarefaEntity tarefa = new TarefaEntity();
                    tarefa.setIdTarefas(rs.getInt(1));
                    tarefa.setDescricao(rs.getString(2));
                    tarefa.setDataInicio(rs.getString(3));
                    tarefa.setDataPrevista(rs.getString(4));
                    tarefa.setDataFinalizacao(rs.getString(5));
                    tarefa.setSituacao(rs.getString(6));
                    tarefa.setNomeColaborador(rs.getString(9));
                    tarefa.setNomeProjeto(rs.getString(10));
                    tarefas.add(tarefa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarefas;
    }
}

