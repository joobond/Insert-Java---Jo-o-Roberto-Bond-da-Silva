/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bond
 */
public class Poupex {

    JLabel juros = new JLabel("Juros mens. %: ");
    JLabel anos = new JLabel("Num. de anos: ");
    JLabel deposito = new JLabel("Dep. Mensal: R$");
    JLabel poupado = new JLabel("Total Poup: R$");

    JButton limpar = new JButton("Limpar");
    JButton calcular = new JButton("Calcular");

    JTextField jurosT = new JTextField(270);
    JTextField anosT = new JTextField(270);
    JTextField depositoT = new JTextField(270);
    JTextField poupadoT = new JTextField(270);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Poupex();
            }
        });

    }

    Poupex() {

        JFrame frame = new JFrame("Poupex");
        frame.setSize(400, 230);
        frame.setLayout(null);

        //Nomes
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 100, 230);

        juros.setBounds(10, 2, 100, 30);
        p1.add(juros);

        anos.setBounds(10, 40, 100, 30);
        p1.add(anos);

        deposito.setBounds(10, 80, 100, 30);
        p1.add(deposito);

        poupado.setBounds(10, 120, 100, 30);
        p1.add(poupado);

        limpar.setBounds(10, 157, 90, 30);
        limpar.setForeground(Color.red);
        limpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                 jurosT.setText(null);
                 depositoT.setText(null);
                 anosT.setText(null);
                 poupadoT.setText(null);
                   
            }
        });
        p1.add(limpar);

        frame.add(p1);

        //Fields
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(100, 0, 300, 230);

        jurosT.setBounds(10, 3, 270, 30);
        p2.add(jurosT);

        anosT.setBounds(10, 40, 270, 30);
        p2.add(anosT);

        depositoT.setBounds(10, 80, 270, 30);
        p2.add(depositoT);

        poupadoT.setBounds(10, 120, 270, 30);
        p2.add(poupadoT);

        calcular.setBounds(70, 157, 100, 30);
        calcular.setForeground(new Color(0,100,0));
        calcular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                    double c = Double.parseDouble(depositoT.getText());
                    double i = Double.parseDouble(jurosT.getText());
                    int t = Integer.parseInt(anosT.getText());
                    i = i/100;
                    t = t * 12; 

                    double p = c*((Math.pow((1+i), t)-1)/i);
                    DecimalFormat df = new DecimalFormat("###,###,###,###.00");

                    poupadoT.setText("R$ "+df.format(p));

            }
        });
        p2.add(calcular);

        frame.add(p2);

        //Mostrar
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
