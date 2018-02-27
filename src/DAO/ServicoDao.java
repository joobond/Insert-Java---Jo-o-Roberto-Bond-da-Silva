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
    
    public void inserirServico(Servico serv){
        String sql = "INSERT INTO servico (idservico,nome,valor) VALUES (?,?,?)";
        
        try {
            PreparedStatement stmt =  con.prepareStatement(sql);
            
            //Passando a informação
            stmt.setInt(1, serv.getIdservico());
            stmt.setString(2, serv.getNome());
            stmt.setDouble(3, serv.getValor());
            
            //Executando a query
            stmt.execute();
            System.out.println(serv.getNome()+" inserido com sucesso!");
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
            stmt.setInt(1, serv.getIdservico());
            //Executando
            stmt.execute();
            //Fechando
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Aconteceu um erro ao deletar o serviço!");
            throw new RuntimeException(e);
        }

    }
    
    public void visualizarServicos() {
        String sql = "SELECT * FROM servico";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: "+rs.getInt("idservico"));
                System.out.println("Descrição: "+rs.getString("nome"));
                System.out.println("-----------------------------");
            }
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
