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
import model.Produto;

/**
 *
 * @author Bond
 */
public class ProdutoDao {
    
    private final Connection con;

    public ProdutoDao() throws SQLException {
        this.con = Conexao.getConnection();
    }
    
    public void inserirProduto(Produto produto){
        String sql = "INSERT INTO produto (idproduto,nome,preco,quantidade) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement stmt =  con.prepareStatement(sql);
            
            //Passando a informação
            stmt.setInt(1, produto.getIdproduto());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setFloat(4, produto.getQuantidade());
            
            //Executando a query
            stmt.execute();
            System.out.println(produto.getNome()+" inserido com sucesso!");
            //Fechando a conexao
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deletarProduto(Produto pro) throws SQLException {
        String sql = "DELETE FROM produto WHERE idproduto=?";

        try {
            //Preparando
            PreparedStatement stmt = con.prepareStatement(sql);
            //Passando as informações
            stmt.setInt(1, pro.getIdproduto());
            //Executando
            stmt.execute();
            //Fechando
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Aconteceu um erro ao deletar o produto!");
            throw new RuntimeException(e);
        }

    }
    
    public void visualizarProdutos() {
        String sql = "SELECT * FROM produto";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: "+rs.getInt("idproduto"));
                System.out.println("Descrição: "+rs.getString("nome"));
                System.out.println("-----------------------------");
            }
            
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizarProduto(Produto pro) {
        String sql = "UPDATE produto SET nome=?,preco=?,quantidade=? WHERE idproduto=?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            //Passando a informação
            stmt.setString(1, pro.getNome());
            stmt.setDouble(2, pro.getPreco());
            stmt.setFloat(3, pro.getQuantidade());
            stmt.setInt(4, pro.getIdproduto());

            //Executando a query
            stmt.execute();
            System.out.println(pro.getNome() + " atualizado com sucesso!");
            //Fechando a conexao
            stmt.close();
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
