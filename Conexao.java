
package com.mycompany.projetoong;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/Ong";
    private static final String USER = "root";
    private static final String PASSWORD = "----";

    public static  Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
    
}
