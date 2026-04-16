/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.mycompany.projetoong.Conexao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ASPM
 */
public class Cadastro {
   
    public static int cadastrarDoador(String nome, String email, String cpf, String endereco) {

    String sql = "INSERT INTO Doador (Nome, email, cpf, endereco) VALUES (?, ?, ?, ?)";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, nome);
        stmt.setString(2, email);
        stmt.setString(3, cpf);
        stmt.setString(4, endereco);

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();

        if (rs.next()) {
            int id = rs.getInt(1);
            JOptionPane.showMessageDialog(null, "Doador cadastrado! ID: " + id);
            return id;
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
    }

    return -1;
}
  
    public static int cadastrarReceptor(String nome, String email, String cpf, String endereco) {

    String sql = "INSERT INTO Receptor (Nome, email, cpf, endereco) VALUES (?, ?, ?, ?)";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, nome);
        stmt.setString(2, email);
        stmt.setString(3, cpf);
        stmt.setString(4, endereco);

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            JOptionPane.showMessageDialog(null,"Receptor cadastrado com sucesso! ID: " + id);
            return id;
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Erro ao cadastrar: " + e.getMessage());
    }

    return -1;
}
}
