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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.OrdemServico;
import model.Servico;

/**
 *
 * @author Bond
 */
public class OrdemServicoDao {

    private final Connection con;

    public OrdemServicoDao() throws SQLException {
        this.con = Conexao.getConnection();
    }

    public Integer inserirOS(OrdemServico os) {
        String sql = "INSERT INTO ordem_servico (descricao,cliente_id,servico_id) VALUES (?,?,?)";

        try {
            int numeroOrdem = 0;
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Cliente cli;
            Servico serv;
            //Passando a informação
            stmt.setString(1, os.getDescricao());
            stmt.setInt(2, os.getCli().getId());
            stmt.setInt(3, os.getServ().getId());

            //Executando a query
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                numeroOrdem = rs.getInt(1);
            }
            System.out.println("OS inserida com sucesso!");
            //Fechando a conexao
            stmt.close();
            return numeroOrdem;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public OrdemServico ConsultarId(OrdemServico os) throws SQLException {
        String sql = "SELECT * FROM ordem_servico INNER JOIN cliente ON ordem_servico.cliente_id = cliente.id"
                + " WHERE ordem_servico.id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, os.getId());
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            os.getCli().setNome(rs.getString("nome"));
        }

        return os;
    }

    public void deletarOS(OrdemServico os) {
        String sql = "DELETE FROM ordem_servico WHERE id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, os.getId());
            stmt.execute();
            stmt.close();
            System.out.println("Excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao deletar a OS.");
        }
    }

    public List<OrdemServico> consultarOS() {
        String sql = "SELECT * FROM ordem_servico INNER JOIN cliente ON ordem_servico.cliente_id = cliente.id "
                + "INNER JOIN servico ON servico.id = ordem_servico.servico_id";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            List<OrdemServico> retorno = new ArrayList<>();

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("cliente_id"));
                Servico serv = new Servico();
                serv.setId(rs.getInt("servico_id"));
                OrdemServico os = new OrdemServico();
                os.setId(rs.getInt("id"));
                os.setDescricao(rs.getString("descricao"));
                os.setCli(cli);
                os.setServ(serv);
                retorno.add(os);
            }
            stmt.close();
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
