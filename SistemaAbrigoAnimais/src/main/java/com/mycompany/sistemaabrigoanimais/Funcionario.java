/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais;

/**
 *
 * @author Giovana
 */
public abstract class Funcionario extends EntidadeBase implements IFuncionario {
    private String nome;
    private String cpf;
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome) throws RuntimeException {
        if(nome == null || nome.equals("") || nome.length() <= 4) {
            throw new RuntimeException("Nome inválido");
        }
        this.nome = nome;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    @Override
    public String toString(){
        return "Funcionário:" + nome;
    }
    
    public abstract void imprimir();
}