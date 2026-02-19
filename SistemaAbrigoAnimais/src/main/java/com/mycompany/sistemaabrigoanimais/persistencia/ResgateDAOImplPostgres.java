/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import com.mycompany.sistemaabrigoanimais.Resgate;
import com.mycompany.sistemaabrigoanimais.Animal;

/**
 *
 * @author Giovana
 */
public class ResgateDAOImplPostgres implements IResgateDAO {
    private Banco banco = new Banco();

    @Override
    public void inserir(Resgate r) {
        banco.conectar();
        String sql = "INSERT INTO resgate (data_resgate, id_animal) VALUES (";
        sql += "'" + r.getDataResgate() + "', ";
        sql += r.getAnimal().getId();
        sql += ");";
        banco.executarSQL(sql);
        banco.fechar();
    }

    @Override
    public List<Resgate> consultar() {
        List<Resgate> lista = new ArrayList<>();
        banco.conectar();
        String sql = "SELECT * FROM resgate;";
        ResultSet rs = banco.executarConsulta(sql);
        
        try {
            while(rs.next()){
                Resgate r = new Resgate();
                r.setId(rs.getInt("id"));
                r.setDataResgate(rs.getString("data_resgate"));
               
                Animal a = new Animal();
                a.setId(rs.getInt("id_animal"));
                r.setAnimal(a);
                
                lista.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        banco.fechar();
        return lista;
    }

    @Override
    public void atualizar(Resgate r) {
        banco.conectar();
        String sql = "UPDATE resgate SET data_resgate = ?, local_resgate = ?, id_animal = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(r.getDataResgate());
        parametros.add(r.getAnimal().getId());
        parametros.add(r.getId());
        banco.executarPreparedStatement(sql, parametros);
        banco.fechar();
    }

    @Override
    public void remover(Resgate r) {
        banco.conectar();
        String sql = "DELETE FROM resgate WHERE id = " + r.getId() + ";";
        banco.executarSQL(sql);
        banco.fechar();
    }
}
