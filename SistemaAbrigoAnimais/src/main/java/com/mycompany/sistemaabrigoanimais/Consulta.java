/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais;

/**
 *
 * @author Giovana
 */
public class Consulta extends EntidadeBase {
    private String dataConsulta;
    private Animal animal;
    private Veterinario veterinario;
    
    public Consulta(){
        
    }
    
    public Consulta(Animal animal, Veterinario veterinario, String dataConsulta){
        this.animal = animal;
        this.veterinario = veterinario;
        this.dataConsulta = dataConsulta;
    }
    
    public Animal getAnimal(){
        return animal;
    }
    
    public void setAnimal(Animal animal){
        this.animal = animal;
    }
    
    public Veterinario getVeterinario(){
        return veterinario;
    }
    
    public void setVeterinario(Veterinario veterinario){
        this.veterinario = veterinario;
    }
    
    public String getDataConsulta(){
        return dataConsulta;
    }
    
    public void setDataConsulta(String dataConsulta){
        this.dataConsulta = dataConsulta;
    }

    @Override
    public String toString(){
        return "Médico Veterinário: " + veterinario.getNome() + ", animal:" + animal.getNome() + ", data: " + getDataConsulta();
    }
    
    public void imprimir(){
        System.out.println(toString());
    }
}
