/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Giovana
 */
public class Banco {
    private String url = "jdbc:postgresql://localhost:5432/postgres"; 
    private String user = "postgres";
    private String password = "123456";
    private java.sql.Connection conexao;
    
        public void conectar(){
        try {
            conexao = DriverManager.getConnection(url, user, password);
        } catch(Exception erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
        
    }
    
    public void executarSQL(String sql){
        try {
            conexao.createStatement().execute(sql);
        } catch(Exception erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }
    
    public void fechar(){
        try {
            conexao.close();
        } catch(Exception erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }
    
    public void executarPreparedStatement(String sql, List parametros){
        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);
            for (int i = 0; i < parametros.size(); i++) {
                Object obj = parametros.get(i);
                pstm.setObject(i + 1, obj);
            }
            pstm.execute();
        } catch(Exception erro){
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }
    
    public ResultSet executarConsulta(String sql) {
        try {
            return conexao.createStatement().executeQuery(sql);
        } catch(Exception erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }
}
