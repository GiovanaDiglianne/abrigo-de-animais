/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais;

/**
 *
 * @author Giovana
 */
public class Resgate extends EntidadeBase {
    private String dataResgate;
    private Animal animal;
    
    public Resgate(){
        
    }
    
    public Resgate(String dataResgate, Animal animal){
        this.dataResgate = dataResgate;
        this.animal = animal;
    }
    
    public String getDataResgate(){
        return dataResgate;
    }
    
    public void setDataResgate(String dataResgate){
        this.dataResgate = dataResgate;
    }
    
    public Animal getAnimal(){
        return animal;
    }
    
    public void setAnimal (Animal animal){
     this.animal = animal;   
    }
    
    @Override
    public String toString() {
        return "Data de resgate: " + dataResgate + ", animal: " + animal.getNome();
    }
}
