/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais;

/**
 *
 * @author Giovana
 */
public class Adocao extends EntidadeBase {
    private String dataAdocao;
    private String adotante;
    private Animal animal;
    
    public Adocao(){
        
    }
    public Adocao(String dataAdocao, String adotante, Animal animal){
        this.dataAdocao = dataAdocao;
        this.adotante = adotante;
        this.animal = animal;
    }
    
    public String getDataAdocao(){
        return dataAdocao;
    }
    
    public void setDataAdocao(String dataAdoçao){
        this.dataAdocao = dataAdoçao;
    }
    
    public String getAdotante(){
        return adotante;
    }
    
    public void setAdotante(String adotante){
        this.adotante = adotante;
    }
    
    public Animal getAnimal(){
        return animal;
    }
    
    public void setAnimal (Animal animal){
     this.animal = animal;   
    }
    
    @Override
    public String toString() {
        return "Nome do adotante: " + adotante + ", data de adoção: " + dataAdocao + ", animal adotado: " + animal.getNome();
    }
}
