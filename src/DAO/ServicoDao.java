/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Servico;

/**
 *
 * @author Bond
 */
public class ServicoDao {

    private final Connection con;

    public ServicoDao() throws SQLException {
        this.con = Conexao.getConnection();
    }

    public void inserirServico(Servico serv) {
        String sql = "INSERT INTO servico (id,nome,valor) VALUES (?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            //Passando a informação
            stmt.setInt(1, serv.getId());
            stmt.setString(2, serv.getNome());
            stmt.setDouble(3, serv.getValor());

            //Executando a query
            stmt.execute();
            System.out.println(serv.getNome() + " inserido com sucesso!");
            //Fechando a conexao
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarServico(Servico serv) throws SQLException {
        String sql = "DELETE FROM servico WHERE idservico=?";

        try {
            //Preparando
            PreparedStatement stmt = con.prepareStatement(sql);
            //Passando as informações
            stmt.setInt(1, serv.getId());
            //Executando
            stmt.execute();
            //Fechando
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Aconteceu um erro ao deletar o serviço!");
            throw new RuntimeException(e);
        }

    }

    public List<Servico> consultarServicos() {
        String sql = "SELECT * FROM servico";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            List<Servico> retorno = new ArrayList<>();

            while (rs.next()) {
                Servico serv = new Servico();
                serv.setId(rs.getInt("id"));
                serv.setNome(rs.getString("nome"));
                serv.setValor(rs.getFloat("valor"));
                retorno.add(serv);
            }
            stmt.close();
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Servico consultarServicoId(Servico serv) {
        String sql = "SELECT * FROM servico WHERE id=?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, serv.getId());

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                serv.setNome(rs.getString("nome"));
                serv.setValor(rs.getFloat("valor"));

            }
            stmt.close();
            return serv;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarServico(Servico serv) {
        String sql = "UPDATE servico SET nome=?,valor=? WHERE id=?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            //Passando a informação
            stmt.setString(1, serv.getNome());
            stmt.setDouble(2, serv.getValor());
            stmt.setInt(3, serv.getId());

            //Executando a query
            stmt.execute();
            System.out.println(serv.getNome() + " atualizado com sucesso!");
            //Fechando a conexao
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
