/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bond
 */
public class FrameSala {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new FrameSala();
            }
        });
    }
    
    FrameSala(){
        //Criar Frame
        JFrame jf = new JFrame();
        jf.setLocationRelativeTo(null);
        
        //Tamanho Frame
        jf.setSize(300, 200);
        
        //Layout
        jf.setLayout(new FlowLayout());
        
        //Label
        JLabel jl = new JLabel("Nome: ");
        jl.setForeground(Color.blue);
        jf.add(jl);
        
        //TextField
        JTextField jtf = new JTextField(20);
        jf.add(jtf);
        
        //Button
        JButton bt = new JButton("Imprima");
        bt.setSize(30,20);
        jf.add(bt);
        
        //Mostrar
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
