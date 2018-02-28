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
    
    public List<Produto> consultarProdutos() {
        String sql = "SELECT * FROM produto";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            List<Produto> retorno = new ArrayList<>();

            while (rs.next()) {
                Produto pro = new Produto();
                pro.setIdproduto(rs.getInt("idproduto"));
                pro.setNome(rs.getString("nome"));
                pro.setPreco(rs.getDouble("preco"));
                pro.setQuantidade(rs.getFloat("quantidade"));
                retorno.add(pro);
            }
            stmt.close();
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Produto consultarProdutoId(Produto pro){
        String sql = "SELECT * FROM produto WHERE idproduto=?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pro.getIdproduto());
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                pro.setNome(rs.getString("nome"));
                pro.setPreco(rs.getDouble("preco"));
                pro.setQuantidade(rs.getFloat("quantidade"));
                
            }
            stmt.close();
            return pro;
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
