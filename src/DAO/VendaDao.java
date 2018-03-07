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
import model.Produto;
import model.Venda;

/**
 *
 * @author Bond
 */
public class VendaDao {
    private final Connection con;

    public VendaDao() throws SQLException {
        this.con = Conexao.getConnection();
    }
    
    public Integer incluirVenda(Venda ven){
        String sql = "INSERT INTO venda (valor,cliente_id,produto_id) VALUES (?,?,?)";
        
        try {
            int numVenda = 0;
            PreparedStatement stmt =  con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            Cliente cli;
            Produto pro;
            //Passando a informação
            stmt.setDouble(1, ven.getValor());
            stmt.setInt(2,ven.getCli().getId());
            stmt.setInt(3, ven.getPro().getId());
            
            //Executando a query
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                numVenda = rs.getInt(1);
            }
            System.out.println("Venda inserida com sucesso!");
            //Fechando a conexao
            stmt.close();
            return numVenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
     public Venda ConsultarId(Venda ven) throws SQLException{
        String sql = "SELECT * FROM venda INNER JOIN cliente ON venda.cliente_id = cliente.id"
                + " WHERE venda.id=?";
        PreparedStatement stmt =  con.prepareStatement(sql);
        stmt.setInt(1, ven.getId());
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            ven.getCli().setNome(rs.getString("nome"));
        }
        
        return ven;
    }
    
    public void deletarVenda(Venda ven){
        String sql = "DELETE FROM venda WHERE id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, ven.getId());
            stmt.execute();
            stmt.close();
            System.out.println("Excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao deletar a venda.");
        }
    }
    
    public List<Venda> consultarVenda() {
        String sql = "SELECT * FROM venda INNER JOIN cliente ON venda.cliente_id = cliente.id "
                + "INNER JOIN produto ON produto.id = venda.produto_id";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            List<Venda> retorno = new ArrayList<>();

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("cliente_id"));
                Produto pro = new Produto();
                pro.setId(rs.getInt("produto_id"));
                Venda ven = new Venda();
                ven.setId(rs.getInt("id"));
                ven.setValor(rs.getDouble("valor"));
                ven.setCli(cli);
                ven.setPro(pro);
                retorno.add(ven);
            }
            stmt.close();
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
