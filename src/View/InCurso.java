/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Bond
 */
public class InCurso {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new InCurso();
            }
        });
}
    InCurso(){
        //Criar Frame
        JFrame jf = new JFrame();
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setSize(800, 300);
        
        //Bordas Aluno
        TitledBorder dados = new TitledBorder("Dados do Aluno");
        dados.setTitleJustification(TitledBorder.CENTER);
        dados.setTitlePosition(TitledBorder.TOP);
        
        //Bordas Botões
        TitledBorder botoes = new TitledBorder("Botões");
        botoes.setTitleJustification(TitledBorder.CENTER);
        botoes.setTitlePosition(TitledBorder.TOP);
        
        //Painel1
        JPanel jp1 = new JPanel();
        jp1.setLayout(new FlowLayout());
        jp1.setBounds(0, 0, 800, 200);
        jp1.setBorder(dados);
        
        JLabel nome = new JLabel("Nome: ");
        jp1.add(nome);
        
        JTextField nomeT = new JTextField(63);
        jp1.add(nomeT);
        
        JLabel endereco = new JLabel("Endereço: ");
        jp1.add(endereco);
        
        JTextField enderecoT = new JTextField(61);
        jp1.add(enderecoT);
        
        JLabel idade = new JLabel("Idade:      ");
        jp1.add(idade);
        
        JTextField idadeT = new JTextField(62);
        jp1.add(idadeT);
        
        JLabel cpf = new JLabel("CPF:                ");
        jp1.add(cpf);
        
        JTextField cpfT = new JTextField(60);
        jp1.add(cpfT);
        
        JLabel rg = new JLabel("RG:                 ");
        jp1.add(rg);
        
        JTextField rgT = new JTextField(60);
        jp1.add(rgT);
        
        JCheckBox ing = new JCheckBox("Inglês");
        jp1.add(ing);
        
        JCheckBox esp = new JCheckBox("Espanhol");
        jp1.add(esp);
        
        jf.add(jp1);
        
        //Painel2
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout());
        jp2.setBounds(0, 200, 800, 100);
        jp2.setBorder(botoes);
        
        JButton inscricao = new JButton("Inscrição");
        jp2.add(inscricao);
        
        JButton limpar = new JButton("Limpar");
        jp2.add(limpar);
        
        JButton sair = new JButton("Sair");
        jp2.add(sair);
        
        jf.add(jp2);
        
        
        //Mostrar
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    }

