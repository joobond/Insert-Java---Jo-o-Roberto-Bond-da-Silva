/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bond
 */
public class Conexao {

    public static Connection getConnection() throws SQLException {
        final String user = "root";
        final String password = "";
        final String URL = "jdbc:mysql://localhost/servico";
        Connection con;
        con = DriverManager.getConnection(URL, user, password);
        return con;

    }

}
