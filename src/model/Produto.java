/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bond
 */
public class Produto {

    public Produto() {
        
    }
     
    int idproduto;
    String nome;
    double preco;
    float quantidade;

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
