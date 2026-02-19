/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import com.mycompany.sistemaabrigoanimais.Veterinario;
/**
 *
 * @author Giovana
 */
public class VeterinarioDAOImplPostgres implements IVeterinarioDAO {
    private Banco banco = new Banco(); 
    
    @Override
    public void inserir(Veterinario v) {
        banco.conectar();
        String sql = "INSERT INTO veterinario (nome, cpf, crmv, especialidade, salario) VALUES (";
        sql += "'" + v.getNome() + "', ";           
        sql += "'" + v.getCpf() + "', ";            
        sql += "'" + v.getCrmv() + "', ";          
        sql += "'" + v.getEspecialidade() + "', "; 
        sql += v.getSalario();                     
        sql += ");";
        banco.executarSQL(sql);
        banco.fechar();
    }
    
    @Override
    public List<Veterinario> consultar() {
        List<Veterinario> lista = new ArrayList<>();
        banco.conectar();
        String sql = "SELECT * FROM veterinario;";
        ResultSet rs = banco.executarConsulta(sql);

        try {
            while(rs.next()){
                Veterinario v = new Veterinario();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setCpf(rs.getString("cpf"));
                v.setCrmv(rs.getString("crmv"));
                v.setEspecialidade(rs.getString("especialidade"));
                v.setSalario(rs.getFloat("salario"));
                lista.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        banco.fechar();
        return lista;
    }

    @Override
    public void atualizar(Veterinario v) {
        banco.conectar();
        String sql = "UPDATE veterinario SET nome = ?, cpf = ?, crmv = ?, especialidade = ?, salario = ? WHERE id = ?;";

        List parametros = new ArrayList();
        parametros.add(v.getNome());
        parametros.add(v.getCpf());
        parametros.add(v.getCrmv());
        parametros.add(v.getEspecialidade());
        parametros.add(v.getSalario());
        parametros.add(v.getId());
        banco.executarPreparedStatement(sql, parametros); 
        banco.fechar();
    }
    
    @Override
    public void remover(Veterinario v) {
        banco.conectar();
        String sql = "DELETE FROM veterinario WHERE id = " + v.getId() + ";";
        banco.executarSQL(sql);
        banco.fechar();
    }
}
