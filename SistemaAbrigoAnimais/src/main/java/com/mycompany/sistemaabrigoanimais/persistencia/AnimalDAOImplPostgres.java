/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import com.mycompany.sistemaabrigoanimais.Animal;

/**
 *
 * @author Giovana
 */

public class AnimalDAOImplPostgres implements IAnimalDAO {
    
    private Banco banco = new Banco(); // Certifique-se de que o arquivo Banco.java do prof está no mesmo pacote

    @Override
    public void inserir(Animal animal) {
        banco.conectar();
        // Montando o comando SQL para inserir seu animal
        String sql = "INSERT INTO animal (nome, especie, raca, idade, status) VALUES (";
        sql = sql + "'" + animal.getNome() + "',";
        sql = sql + "'" + animal.getEspecie() + "',";
        sql = sql + "'" + animal.getRaca() + "',";
        sql = sql + animal.getIdade() + ","; // Idade é int, não precisa de aspas
        sql = sql + "'" + animal.getStatus() + "'";
        sql = sql + ");";
        
        banco.executarSQL(sql);
        banco.fechar();
    }

    @Override
    public List<Animal> consultar() {
        List<Animal> lista = new ArrayList<>();
        banco.conectar();
        String sql = "SELECT * FROM animal;";
        ResultSet rs = banco.executarConsulta(sql);
        
        try {
            while(rs.next()){
                Animal animal = new Animal();
                // Preenchendo o objeto com os dados que vêm do banco
                animal.setId(rs.getInt("id")); // Herdado da EntidadeBase
                animal.setNome(rs.getString("nome"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
                animal.setIdade(rs.getInt("idade"));
                animal.setStatus(rs.getString("status"));
                lista.add(animal);
            }
        } catch (Exception erro){
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
        
        banco.fechar();
        return lista;
    }

    @Override
    public void atualizar(Animal animal) {
        banco.conectar();
        String sql = "UPDATE animal SET nome = ?, especie = ?, raca = ?, idade = ?, status = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(animal.getNome());
        parametros.add(animal.getEspecie());
        parametros.add(animal.getRaca());
        parametros.add(animal.getIdade());
        parametros.add(animal.getStatus());
        parametros.add(animal.getId());
        
        banco.executarPreparedStatement(sql, parametros); // Usando o método seguro do professor
        banco.fechar();
    }

    @Override
    public void remover(Animal animal) {
        banco.conectar();
        String sql = "DELETE FROM animal WHERE id = " + animal.getId() + ";";
        banco.executarSQL(sql);
        banco.fechar();
    }
}
