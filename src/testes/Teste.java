package testes;

import DAO.ClienteDao;
import DAO.ProdutoDao;
import DAO.ServicoDao;
import java.sql.SQLException;
import model.Cliente;
import model.Produto;
import model.Servico;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bond
 */
public class Teste {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException{
        // TODO code application logic here
        
        //Produto
//        Produto p = new Produto();
//        p.setIdproduto(1);
//        p.setNome("Camisinha");
//        p.setPreco(14.80);
//        p.setQuantidade(10);
////        
//        ProdutoDao pdao = new ProdutoDao();
//        pdao.inserirProduto(p);
//        pdao.deletarProduto(p);
//        pdao.visualizarProdutos();
        
        //Serviço
//        Servico serv = new Servico();
//        serv.setIdservico(1);
//        serv.setNome("Acompanhante");
//        serv.setValor(200);
//        
        ServicoDao sdao = new ServicoDao();
//        sdao.inserirServico(serv);
//        sdao.deletarServico(serv);
        sdao.visualizarServicos();
        
        
        //Cliente
//        Cliente cli = new Cliente();
//        cli.setIdCliente(2);
//        cli.setNome("Eclesio Melo");
//        cli.setEndereco("Rua dos Bobos Nº 0");
//        cli.setIdade(19);
//        cli.setCpf(654321);
//        cli.setSexo("M");
//        
//        ClienteDao cdao = new ClienteDao();
//        cdao.inserirCliente(cli);
//        cdao.deletarCliente(cli);
//        cdao.visualizarClientes();
       
        
    }
    
}
