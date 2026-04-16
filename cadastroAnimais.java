/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoong;
import com.mycompany.projetoong.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



/**
 *
 * @author ASPM
 */
public class cadastroAnimais {

  public static void cadastrarAnimais(String nome, String raca, int idade, String sexo, String tipo, int idDoador) {

    String sql = "INSERT INTO Animal (Nome, Raca, idade, sexo, id_doador) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        stmt.setString(2, raca);
        stmt.setInt(3, idade);
        stmt.setString(4, sexo);
        stmt.setString(5, tipo);
        stmt.setInt(5, idDoador);

        stmt.executeUpdate();

        JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
    }
}
    public static void listarAnimais() {

    String sql = "SELECT * FROM Animal WHERE Status = 'Disponivel'";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        JOptionPane.showMessageDialog(null,"Animais disponíveis para adoção:");

        while (rs.next()) {
            int id = rs.getInt("id_animal");
            String nome = rs.getString("Nome");
            String raca = rs.getString("Raca");
            String tipo=rs.getString("tipo");
            int idade = rs.getInt("idade");
            String sexo = rs.getString("sexo");

            System.out.println("----------------------");
            JOptionPane.showMessageDialog(null,"ID: " + id+"\n"+"Nome: "
                    + nome+"\n"+"Tipo: "+tipo+"\n"+"Raça: " + raca+"\n"+"Idade: " + idade+"\n"+"Sexo: " + sexo+"\n");
            
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Não foi possível listar os animais: " + e.getMessage());
    }
    
    }
    public static void verLocalizacao(int idAnimal) {

    String sql = "SELECT d.endereco " +
                 "FROM Animal a " +
                 "JOIN Doador d ON a.id_doador = d.id_doador " +
                 "WHERE a.id_animal = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idAnimal);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String endereco = rs.getString("endereco");
            JOptionPane.showMessageDialog(null,"Localização do animal: " + endereco);
        } else {
            JOptionPane.showMessageDialog(null,"Animal não encontrado.");
        }

    } catch (Exception e) {
       JOptionPane.showMessageDialog(null,"Erro ao buscar localização: " + e.getMessage());
    }

    }
    public static void AdotarAnimal(int idAnimal,int idReceptor){
    String Sql="UPDATE Animal SET Status = 'Adotado', Id_Receptor = ? WHERE Id_Animal = ?";
    
    try(Connection conn=Conexao.conectar();
            PreparedStatement stmt=conn.prepareStatement(Sql)){
    stmt.setInt(1,idReceptor);
    stmt.setInt(2,idAnimal);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null,"Adoção realizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null,"Animal não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao adotar: " + e.getMessage());
        }
    }
}
    

    

    
        

  
    

