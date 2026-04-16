/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetoong;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ASPM
 */
public class ProjetoOng {

    public static void main(String[] args) {
      JFrame janela=new JFrame();
      janela.setTitle("Adote fácil");
      janela.setBounds(300,200,600,500);
      JLabel Nome=new JLabel("Adote Fácil");
      Nome.setFont(new Font("Arial", Font.BOLD, 28));
      Nome.setBounds(220, 20, 600, 50);
      janela.add(Nome);
      janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      janela.setLayout(null);
      janela.setVisible(true);
      JButton botaoListar=new JButton("Animais disponiveis?");
      botaoListar.setBounds(200,100,200,40);
      janela.add(botaoListar);
      JButton botaoAdotar=new JButton("Quero adotar um animal!");
      botaoAdotar.setBounds(200, 160, 200, 40);
      janela.add(botaoAdotar);
      JButton botaoDoar=new JButton("Quero registrar um animal!");
      botaoDoar.setBounds(200, 220, 200, 40);
      janela.add(botaoDoar);
      
      botaoListar.addActionListener(e->{
      cadastroAnimais.listarAnimais();
      });
      
      botaoAdotar.addActionListener(e->{
          String NomeReceptor=JOptionPane.showInputDialog("Digite o nome do novo tutor:");
          String EmailReceptor=JOptionPane.showInputDialog("Digite o Email do novo tutor:");
          String CpfReceptor=JOptionPane.showInputDialog("Digite o cpf do novo tutor:");
          String EnderecoReceptor=JOptionPane.showInputDialog("digite o endereço do novo tutor:");
          int idReceptor = Cadastro.cadastrarReceptor(NomeReceptor,EmailReceptor,CpfReceptor,EnderecoReceptor);
          cadastroAnimais.listarAnimais();
          int idAnimal = Integer.parseInt(JOptionPane.showInputDialog("ID do animal:"));
                  cadastroAnimais.verLocalizacao(idAnimal);
          String Opcao=JOptionPane.showInputDialog("Deseja adotar o animal?(sim/não)");
          if(Opcao != null && Opcao.toLowerCase().equals("sim")){
              cadastroAnimais.AdotarAnimal(idAnimal, idReceptor);
          } 
          else{ JOptionPane.showMessageDialog(null,"Ok,obrigado");}
    
      });
      botaoDoar.addActionListener(e->{
            String NomeDoador=JOptionPane.showInputDialog("Digite o nome do doador:");
            String EmailDoador=JOptionPane.showInputDialog("Digite o Email do doador:");
            String Cpf=JOptionPane.showInputDialog("Digite o Cpf do doador:");
            String Endereco=JOptionPane.showInputDialog("Digite o endereço do doador(onde o animal está localizado):");
            int idDoador = Cadastro.cadastrarDoador(NomeDoador, EmailDoador, Cpf, Endereco);
      
            String nomeAnimal = JOptionPane.showInputDialog("Nome do animal:");
            String TipoAnimal=JOptionPane.showInputDialog("Qual o tipo do animal(Cachorro,Gato,outros...)");
            String raca = JOptionPane.showInputDialog("Raça:");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade:"));
            String sexo = JOptionPane.showInputDialog("Sexo:");
            cadastroAnimais.cadastrarAnimais(nomeAnimal, raca, idade, sexo,TipoAnimal, idDoador);
        });
    }
}
