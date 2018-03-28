/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Bond
 */
public class JOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Mensagens
        JOptionPane.showMessageDialog(null, "Erro", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Informação", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Alerta", "Mensagem de Alerta", JOptionPane.WARNING_MESSAGE);
        
        //Confirmação
        JOptionPane.showConfirmDialog(null, "Yes or No?", "Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showConfirmDialog(null, "Okay or Cancel?", "Confirmation", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
        JOptionPane.showConfirmDialog(null, "Sim ou Não?", "Confirmação", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        //Inserção
        JOptionPane.showInputDialog(null,"Qual sue nome? ","Pergunta",JOptionPane.QUESTION_MESSAGE);
        
        //Opção
        String[] options = {"Você", "Sua irmã", "Sua mãe", "Sua tia","Nada"};
        JOptionPane.showOptionDialog(null, "O que você quer?", "Escolha", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        
    }
    
}
