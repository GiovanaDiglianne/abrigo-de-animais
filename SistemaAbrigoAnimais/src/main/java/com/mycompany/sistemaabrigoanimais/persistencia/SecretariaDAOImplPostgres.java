/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import com.mycompany.sistemaabrigoanimais.Secretaria;

/**
 *
 * @author Giovana
 */
public class SecretariaDAOImplPostgres implements ISecretariaDAO {
    private Banco banco = new Banco(); 

    @Override
    public void inserir(Secretaria s) {
        banco.conectar();
        String sql = "INSERT INTO secretaria (nome, cpf, telefone, email, data_nascimento, salario) VALUES (";
        sql += "'" + s.getNome() + "', ";           
        sql += "'" + s.getCpf() + "', ";            
        sql += "'" + s.getTelefone() + "', ";       
        sql += "'" + s.getEmail() + "', ";          
        sql += "'" + s.getDataNascimento() + "', "; 
        sql += s.getSalario();                      
        sql += ");";
        banco.executarSQL(sql);
        banco.fechar();
    }

    @Override
    public List<Secretaria> consultar() {
        List<Secretaria> lista = new ArrayList<>();
        banco.conectar();
        String sql = "SELECT * FROM secretaria;";
        ResultSet rs = banco.executarConsulta(sql);
        
        try {
            while(rs.next()){
                Secretaria s = new Secretaria();
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setCpf(rs.getString("cpf"));
                s.setTelefone(rs.getString("telefone"));
                s.setEmail(rs.getString("email"));
                s.setDataNascimento(rs.getString("data_nascimento"));
                s.setSalario(rs.getFloat("salario"));
                lista.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        banco.fechar();
        return lista;
    }

    @Override 
    public void atualizar(Secretaria s) {
        banco.conectar();
        String sql = "UPDATE secretaria SET nome = ?, cpf = ?, telefone = ?, email = ?, data_nascimento = ?, salario = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(s.getNome());          
        parametros.add(s.getCpf());           
        parametros.add(s.getTelefone());       
        parametros.add(s.getEmail());         
        parametros.add(s.getDataNascimento()); 
        parametros.add(s.getSalario());        
        parametros.add(s.getId());      
        banco.executarPreparedStatement(sql, parametros);
        banco.fechar();
    }
    
    @Override 
    public void remover(Secretaria s) {
        banco.conectar();
        String sql = "DELETE FROM secretaria WHERE id = " + s.getId() + ";";
        banco.executarSQL(sql);
        banco.fechar();
    }
}
