/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.List;
import com.mycompany.sistemaabrigoanimais.Animal;

/**
 *
 * @author Giovana
 */

public interface IAnimalDAO {
    
    public void inserir(Animal animal);
    
    public List<Animal> consultar();
    
    public void atualizar(Animal animal);
    
    public void remover(Animal animal);
}
