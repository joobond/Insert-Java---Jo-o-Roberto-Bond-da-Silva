package testes;

import DAO.ClienteDao;
import DAO.OrdemServicoDao;
import DAO.ProdutoDao;
import DAO.ServicoDao;
import DAO.VendaDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.OrdemServico;
import model.Produto;
import model.Servico;
import model.Venda;


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
        Produto p = new Produto();
        p.setId(15);
        p.setNome("Camisinha");
        p.setValor(15);
        p.setQuantidade(10);
        List<Produto> listaProduto = new ArrayList<>();
//        
//        ProdutoDao pdao = new ProdutoDao();
//        pdao.inserirProduto(p);
//        pdao.deletarProduto(p);
//        pdao.atualizarProduto(p);
//        listaProduto=pdao.consultarProdutos();
        
//        for(Produto p : listaProduto){
//            System.out.println("ID: "+p.getIdproduto());
//            System.out.println("Nome: "+p.getNome());
//            System.out.println("---------------------------");
//        }
        
        //Serviço
//        Servico serv = new Servico();
//        serv.setId(8);
//        serv.setNome("Acompanhantes");
//        serv.setValor(200);
////        
//        ServicoDao sdao = new ServicoDao();
//        sdao.inserirServico(serv);
//        sdao.deletarServico(serv);
//        sdao.atualizarServico(serv);
//        sdao.visualizarServicos();
        
        
        //Cliente
        Cliente cli = new Cliente();
        cli.setId(7);
        cli.setNome("João Bond");
        cli.setEndereco("Rua dos Bobos Nº 0");
        cli.setIdade(19);
        cli.setCpf(654321);
//        
//        ClienteDao cdao = new ClienteDao();
//        cdao.inserirCliente(cli);
//        cdao.deletarCliente(cli);
//        cdao.visualizarClientes();
//        cdao.atualizarCliente(cli);
       
//          OrdemServico os = new OrdemServico();
//          os.setId(2);
//          os.setDescricao("Formatação de computador");
//          os.setCli(cli);
//          os.setServ(serv);
//        
//        List<OrdemServico> listaOS = new ArrayList<>();
////          
//          OrdemServicoDao osdao = new OrdemServicoDao();
//          listaOS = osdao.consultarOS();
//          
//          for (OrdemServico o : listaOS) {
//              System.out.println("ID: "+o.getId());
//              System.out.println("Descrição: "+o.getDescricao());
//              System.out.println("Cliente: "+o.getCli().getId());
//              System.out.println("Serviço: "+o.getServ().getId());
//              System.out.println("---------------------------------------");
//        }
//          osdao.inserirOS(os);
//          osdao.ConsultarId(os);
//          osdao.deletarOS(os);
        
        //Venda
        Venda ven = new Venda();
        //ven.setId(1);
        ven.setCli(cli);
        ven.setPro(p);
        ven.setValor(35);
        
        VendaDao vdao = new VendaDao();
        List<Venda> listaVen = new ArrayList<>();         
          listaVen = vdao.consultarVenda();
          
          for (Venda v : listaVen) {
              System.out.println("ID: "+v.getId());
              System.out.println("Valor: "+v.getValor());
              System.out.println("Cliente: "+v.getCli().getId());
              System.out.println("PRoduto: "+v.getPro().getId());
              System.out.println("---------------------------------------");
        }
//        vdao.incluirVenda(ven);
        //vdao.ConsultarId(ven);
//        vdao.deletarVenda(ven);
        
        
    }
    
}
