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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bond
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new Login();
            }
        });
    }
    
    Login(){
        //Criar Frame
        JFrame jf = new JFrame();
        jf.setLocationRelativeTo(null);
        
        //Tamanho Frame
        jf.setSize(400, 100);
        
        //Layout
        jf.setLayout(new FlowLayout());
        
        //Label Username
        JLabel jl1 = new JLabel("Username: ");
        jl1.setForeground(Color.blue);
        jf.add(jl1);
        
        //TextField Username
        JTextField jtf1 = new JTextField(8);
        jtf1.setBackground(Color.yellow);
        jf.add(jtf1);
        
        //Label Password
        JLabel jl2 = new JLabel("Password: ");
        jl2.setForeground(Color.blue);
        jf.add(jl2);
        
        //PasswordField Password
        JPasswordField pf = new JPasswordField(8);
        pf.setBackground(Color.yellow);
        jf.add(pf);
        
        //Button Logar
        JButton bt1 = new JButton("Logar");
        bt1.setSize(80,100);
        bt1.setBackground(Color.yellow);
        jf.add(bt1);
        
        //Button Cancel
        JButton bt2 = new JButton("Cancel");
        bt2.setSize(80,100);
        bt2.setBackground(Color.black);
        bt2.setForeground(Color.white);
        jf.add(bt2);
        
        //Mostrar
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
