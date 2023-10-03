
package helloworld;

import javax.swing.JOptionPane;


public class Helloworld {

    
    public static void main(String[] args) {
        String nome;
        int idade;
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
        nome = JOptionPane.showInputDialog("Digite o nome");
        JOptionPane.showMessageDialog(null, "Nome cadastrado: " + nome + "\nIdade cadastrada: " + idade);
    }
    
}
