/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import com.mycompany.sistemaabrigoanimais.Adocao;
import com.mycompany.sistemaabrigoanimais.Animal;

/**
 *
 * @author Giovana
 */
public class AdocaoDAOImplPostgres implements IAdocaoDAO {
    private Banco banco = new Banco();

    @Override
    public void inserir(Adocao a) {
        banco.conectar();
        String sql = "INSERT INTO adocao (data_adocao, nome_adotante, id_animal) VALUES (";
        sql += "'" + a.getDataAdocao() + "', ";
        sql += "'" + a.getAdotante() + "', ";
        sql += a.getAnimal().getId(); 
        sql += ");";
        banco.executarSQL(sql); 
        banco.fechar(); 
    }

    @Override
    public List<Adocao> consultar() {
        List<Adocao> lista = new ArrayList<>();
        banco.conectar();
        String sql = "SELECT * FROM adocao;";
        ResultSet rs = banco.executarConsulta(sql);
        
        try {
            while(rs.next()){
                Adocao a = new Adocao();
                a.setId(rs.getInt("id"));
                a.setDataAdocao(rs.getString("data_adocao"));
                a.setAdotante(rs.getString("nome_adotante"));
                Animal animal = new Animal();
                animal.setId(rs.getInt("id_animal"));
                a.setAnimal(animal);
                
                lista.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        banco.fechar();
        return lista;
    }

    @Override
    public void atualizar(Adocao a) {
        banco.conectar();
        String sql = "UPDATE adocao SET data_adocao = ?, nome_adotante = ?, id_animal = ? WHERE id = ?;";
        
        List parametros = new ArrayList();
        parametros.add(a.getDataAdocao());
        parametros.add(a.getAdotante());
        parametros.add(a.getAnimal().getId());
        parametros.add(a.getId());
        banco.executarPreparedStatement(sql, parametros);
        banco.fechar();
    }

    @Override
    public void remover(Adocao a) {
        banco.conectar();
        String sql = "DELETE FROM adocao WHERE id = " + a.getId() + ";";
        banco.executarSQL(sql);
        banco.fechar();
    }
}
