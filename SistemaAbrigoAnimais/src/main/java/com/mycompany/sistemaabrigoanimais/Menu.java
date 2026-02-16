/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Giovana
 */
public class Menu {
    private int opcao;
    private Scanner teclado = new Scanner(System.in);
    
    private List<Animal> animais = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();
    private List<Resgate> resgates = new ArrayList<>();
    private List<Adocao> adocoes = new ArrayList<>();
    
    public void mostrarOpcoes(){
        System.out.println("\n ABRIGO DE ANIMAIS - Giovana Diglianne");
        System.out.println("1 - Cadastrar Animal");
        System.out.println("2 - Cadastrar Veterinário");
        System.out.println("3 - Cadastrar Secretária");
        System.out.println("4 - Registrar Resgate");
        System.out.println("5 - Registrar Adoção");
        System.out.println("6 - Agendar Consulta Veterinária");
        System.out.println("7 - Listar Consultas");
        System.out.println("99 - Sair");
        // colocar um listar consultas
    }
    
    public void executar(){
        opcao = 0;
        while(opcao != 99) {
            mostrarOpcoes();
            System.out.println("Digite a opção desejada:");
            try {
                opcao = teclado.nextInt();
                checarOpcao();
            } catch(InputMismatchException erro) {
                System.out.println("Opção Inválida, digite uma opção da lista");
                teclado.nextLine();
            }
            
        }
    }
    
    private void checarOpcao(){
        switch(opcao){
            case 1:
                System.out.println("Cadastrando Animal");
                cadastrarAnimal();
                break;
            case 2:
                System.out.println("Cadastrando Veterinário");
                cadastrarVeterinario();
                break;
            case 3:
                System.out.println("Cadastrando Secretaria");
                cadastrarSecretaria();
                break;
            case 4:
                System.out.println("Registrando Resgate");
                registrarResgate();
                break;
            case 5:
                System.out.println("Resgistrando Adoção");
                listarAnimais();
                registrarAdocao();
                break;
            case 6:
                System.out.println("Agendando Consulta");
                listarAnimais();
                listarFuncionarios();
                agendarConsulta();
                break;
            case 7:
                System.out.println("Listando Consultas");
                listarConsultas();
                break;
            case 99:
                System.out.println("Saindo do Sistema...");
                break;
            default:
                System.out.println("Digite uma opção válida");
                break;
        }
    }
    
    private void listarConsultas(){
        for (int i = 0; i < consultas.size(); i++) {
            Consulta c = consultas.get(i);
            System.out.println(i + " " + c.toString());            
        }
    }
    
    private void listarAnimais(){
        for (int i = 0; i < animais.size(); i++) {
            Animal a = animais.get(i);
            System.out.println(i + " " + a.toString());            
        }
    }
    
    private void listarFuncionarios(){
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);
            System.out.println(i + " " + f.toString());            
        }
    }
    
    private void lerNome(Funcionario funcionario){
        while(true) {
            System.out.print("Digite o nome do funcionário: ");
            String nome = teclado.nextLine();
            try {
                funcionario.setNome(nome);
                break;
            } catch(RuntimeException erro) {
                System.out.println(erro.getMessage());
            }
        }
    }
    
    private void lerNome(Animal animal){
        while(true) {
            System.out.print("Digite o nome do animal: ");
            String nome = teclado.nextLine();
            try {
                animal.setNome(nome);
                break;
            } catch(RuntimeException erro) {
                System.out.println(erro.getMessage());
            }
        }
    }

    private int getInt(String mensagem){
        System.out.print(mensagem);
        while(true) {
            try {
                return teclado.nextInt();
            } catch(RuntimeException erro) {
                System.out.println(erro.getMessage());
                teclado.nextLine();
            }
        }
    }
    
    private void agendarConsulta(){
        Consulta c = new Consulta();
        teclado.nextLine();
        
        System.out.print("Digite a data da consulta: ");
        String data = teclado.nextLine();
        c.setDataConsulta(data);
        
        int idx = getInt("Selecione o Médico: ");
        c.setVeterinario((Veterinario) funcionarios.get(idx));
        
        teclado.nextLine();
        idx = getInt("Selecione o Paciente: ");
        c.setAnimal((Animal) animais.get(idx));
        
        teclado.nextLine();
        idx = getInt("Selecione o índice da Secretaria: ");
        c.setSecretaria((Secretaria) funcionarios.get(idx));
        consultas.add(c);
    }
    
}