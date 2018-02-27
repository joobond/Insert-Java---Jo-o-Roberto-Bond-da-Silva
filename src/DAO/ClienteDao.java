/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        String sql = "INSERT INTO cliente (idCliente,nome,endereco,idade,cpf,sexo) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            //Passando a informação
            stmt.setInt(1, cli.getIdCliente());
            stmt.setString(2, cli.getNome());
            stmt.setString(3, cli.getEndereco());
            stmt.setInt(4, cli.getIdade());
            stmt.setFloat(5, cli.getCpf());
            stmt.setString(6, cli.getSexo());

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
        String sql = "DELETE FROM cliente WHERE idCliente=?";

        try {
            //Preparando
            PreparedStatement stmt = con.prepareStatement(sql);
            //Passando as informações
            stmt.setInt(1, cli.getIdCliente());
            //Executando
            stmt.execute();
            //Fechando
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Aconteceu um erro ao deletar o cliente!");
            throw new RuntimeException(e);
        }

    }
}
