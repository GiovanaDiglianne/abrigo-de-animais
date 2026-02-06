/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais;

/**
 *
 * @author Giovana
 */
public class Veterinario extends Funcionario {
    private String crmv;
    private String especialidade;
    private float salario;
    
    public Veterinario(){
        
    }
    
    public Veterinario(String crmv, String nome, String especialidade, float salario){
        this.crmv = crmv;
        setNome(nome);
        this.especialidade = especialidade;
        this.salario = salario;
    }
    
    public String getCrmv(){
        return crmv;
    }
    
    public void setCrmv(String crmv){
        this.crmv = crmv;
    }
    
    
    public String getEspecialidade(){
        return especialidade;
    }
    
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    
    public float getSalario(){
        return salario;
    }
    
    public void setSalario(float salario){
        this.salario = salario;
    }
    
    @Override
    public String toString(){
        return "Médico Veterinário: " + getNome() + ", " + "crmv: " + crmv;
    }
    
    @Override
    public void imprimir(){
        System.out.println(toString());
    }
}