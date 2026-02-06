/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais;

/**
 *
 * @author Giovana
 */
public final class Secretaria extends Funcionario {
    private String telefone;
    private String dataNascimento;
    private float salario;
    private String email;
    
    public Secretaria(){
        
    }

    public Secretaria(String nome, String telefone, String email, String dataNascimento, float salario) {
        this.telefone = telefone;
        setNome(nome);
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.email = email;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getDataNascimento(){
        return dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public float getSalario(){
        return salario;
    }
    
    public void setSalario(float salario){
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return "Secretaria: " + getNome();
    }
    
    @Override
    public void imprimir(){
        System.out.println(toString());
    }
}
