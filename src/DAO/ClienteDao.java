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
import model.Cliente;

/**
 *
 * @author Bond
 */
public class ClienteDao {

    private final Connection con;

    public ClienteDao() throws SQLException {
        this.con = Conexao.getConnection();
    }

    public void inserirCliente(Cliente cli) {
        String sql = "INSERT INTO cliente (id,nome,endereco,idade,cpf) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            //Passando a informação
            stmt.setInt(1, cli.getId());
            stmt.setString(2, cli.getNome());
            stmt.setString(3, cli.getEndereco());
            stmt.setInt(4, cli.getIdade());
            stmt.setFloat(5, cli.getCpf());

            //Executando a query
            stmt.execute();
            System.out.println(cli.getNome() + " inserido com sucesso!");
            //Fechando a conexao
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarCliente(Cliente cli) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id=?";

        try {
            //Preparando
            PreparedStatement stmt = con.prepareStatement(sql);
            //Passando as informações
            stmt.setInt(1, cli.getId());
            //Executando
            stmt.execute();
            //Fechando
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Aconteceu um erro ao deletar o cliente!");
            throw new RuntimeException(e);
        }

    }

    public List<Cliente> consultarClientes() {
        String sql = "SELECT * FROM cliente";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            List<Cliente> retorno = new ArrayList<>();

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setIdade(rs.getInt("idade"));
                cli.setCpf(rs.getFloat("cpf"));
                retorno.add(cli);
            }

            stmt.close();
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente consultarClienteId(Cliente cli) {
        String sql = "SELECT * FROM cliente WHERE id=?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cli.getId());

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                cli.setNome(rs.getString("nome"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setIdade(rs.getInt("idade"));
                cli.setCpf(rs.getFloat("cpf"));

            }
            stmt.close();
            return cli;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarCliente(Cliente cli) {
        String sql = "UPDATE cliente SET nome=?,endereco=?,idade=?,cpf=? WHERE id=?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            //Passando a informação
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getEndereco());
            stmt.setInt(3, cli.getIdade());
            stmt.setFloat(4, cli.getCpf());
            stmt.setInt(5, cli.getId());

            //Executando a query
            stmt.execute();
            System.out.println(cli.getNome() + " atualizado com sucesso!");
            //Fechando a conexao
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
