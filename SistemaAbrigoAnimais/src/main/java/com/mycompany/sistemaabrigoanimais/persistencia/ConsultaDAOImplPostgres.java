/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import com.mycompany.sistemaabrigoanimais.Consulta;
import com.mycompany.sistemaabrigoanimais.Animal;
import com.mycompany.sistemaabrigoanimais.Veterinario;

/**
 *
 * @author Giovana
 */
public class ConsultaDAOImplPostgres implements IConsultaDAO {
    private Banco banco = new Banco();

    @Override
    public void inserir(Consulta c) {
        banco.conectar();
        String sql = "INSERT INTO consulta (data_consulta, id_animal, id_veterinario) VALUES (";
        sql += "'" + c.getDataConsulta() + "', ";
        sql += c.getAnimal().getId() + ", ";      
        sql += c.getVeterinario().getId();        
        sql += ");";
        banco.executarSQL(sql);
        banco.fechar();
    }

    @Override
    public List<Consulta> consultar() {
        List<Consulta> lista = new ArrayList<>();
        banco.conectar();
        String sql = "SELECT * FROM consulta;";
        ResultSet rs = banco.executarConsulta(sql);
        
        try {
            while(rs.next()){
                Consulta c = new Consulta();
                c.setId(rs.getInt("id"));
                c.setDataConsulta(rs.getString("data_consulta"));
                
                Animal a = new Animal();
                a.setId(rs.getInt("id_animal"));
                c.setAnimal(a);
                
                Veterinario v = new Veterinario();
                v.setId(rs.getInt("id_veterinario"));
                c.setVeterinario(v);
                
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        banco.fechar();
        return lista;
    }

    @Override
    public void atualizar(Consulta c) {
        banco.conectar();
        String sql = "UPDATE consulta SET data_consulta = ?, id_animal = ?, id_veterinario = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(c.getDataConsulta());
        parametros.add(c.getAnimal().getId());
        parametros.add(c.getVeterinario().getId());
        parametros.add(c.getId());
        banco.executarPreparedStatement(sql, parametros);
        banco.fechar();
    }

    @Override
    public void remover(Consulta c) {
        banco.conectar();
        String sql = "DELETE FROM consulta WHERE id = " + c.getId() + ";";
        banco.executarSQL(sql);
        banco.fechar();
    }
}
