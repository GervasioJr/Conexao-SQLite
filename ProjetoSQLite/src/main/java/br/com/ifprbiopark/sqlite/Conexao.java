/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifprbiopark.sqlite;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UFPR
 */
public class Conexao {
    public static void main(String[] args) {
        connect();
    }
    public static void connect () {
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:tds.db");
            Statement stm = c.createStatement();
            // Criando uma tabela
            stm.execute("CREATE TABLE IF NOT EXISTS ALUNO (ID INTEGER, NOME VARCHAR(50))");
            
            // Inserindo registros
            stm.execute("INSERT INTO ALUNO (ID, NOME) VALUES (1,'BRUNA'), (2,'MARCOS')");
            
            // Lendo registros
            String sql = "SELECT * FROM ALUNO";
            PreparedStatement psm = c.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()){
                System.out.println("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
