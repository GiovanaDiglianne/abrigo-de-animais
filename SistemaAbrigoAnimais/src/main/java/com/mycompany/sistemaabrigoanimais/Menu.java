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
        System.out.println("1 - Registrar Resgate");
        System.out.println("2 - Cadastrar Veterinário");
        System.out.println("3 - Cadastrar Secretária");
        System.out.println("4 - Registrar Adoção");
        System.out.println("5 - Agendar Consulta Veterinária");
        System.out.println("6 - Listar Consultas");
        System.out.println("7 - Listar Resgates");
        System.out.println("8 - Listar Adoções");
        System.out.println("99 - Sair");
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
                System.out.println("Registrando Resgate");
                registrarResgate();
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
                System.out.println("Resgistrando Adoção");
                registrarAdocao();
                break;
            case 5:
                System.out.println("Agendando Consulta");
                agendarConsulta();
                break;
            case 6:
                System.out.println("Listando Consultas");
                listarConsultas();
                break;
            case 7:
                System.out.println("Listando Resgates");
                listarResgates();
                break;
            case 8:
                System.out.println("Listando Adoções");
                listarAdocoes();
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
        System.out.println("\n--- Consultas agendadas ---");
        if(consultas.isEmpty()){
            System.out.println("Nenhuma consulta encontrada.");
        }
        for (int i = 0; i < consultas.size(); i++) {
            Consulta c = consultas.get(i);
            System.out.println(i + " " + c.toString());            
        }
    }
    
    private void listarAnimais(){
        for (int i = 0; i < animais.size(); i++) {
           Animal a = animais.get(i);
            if (!animais.get(i).getStatus().equalsIgnoreCase("Adotado")){
                System.out.println(i + " " + a.toString()); 
            }         
        }
    }
    
    private void listarVeterinarios(){
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);
            if (funcionarios.get(i) instanceof Veterinario){
                System.out.println(i + " " + f.toString()); 
            }           
        } 
    }
    
    private void listarSecretarias(){
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);
            if (funcionarios.get(i) instanceof Secretaria){
                System.out.println(i + " " + f.toString()); 
            }           
        } 
    }
    
    private void listarResgates(){
        System.out.println("\n--- Resgates realizados ---");
        if(resgates.isEmpty()){
            System.out.println("Nenhum resgate encontrada.");
        }
        for (int i = 0; i < resgates.size(); i++) {
            Resgate r = resgates.get(i);
            System.out.println(i + " " + r.toString());            
        }
    }
    
    private void listarAdocoes(){
        System.out.println("\n--- Adoções realizados ---");
        if(adocoes.isEmpty()){
            System.out.println("Nenhuma adoção encontrada.");
        }
        for (int i = 0; i < adocoes.size(); i++) {
            Adocao a = adocoes.get(i);
            System.out.println(i + " " + a.toString());            
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
    private void lerCpf(Funcionario funcionario) {
        while (true) {
            System.out.print("Digite o CPF (apenas números): ");
            String cpf = teclado.nextLine();
            try {
                funcionario.setCpf(cpf); 
                break; 
            } catch (RuntimeException erro) {
                System.out.println("Erro: " + erro.getMessage());
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
        
        boolean temMedico = false;
        boolean temSecretaria = false;
        for (Funcionario f : funcionarios) {
            if (f instanceof Veterinario) {
                temMedico = true;
            }
            if (f instanceof Secretaria) {
                temSecretaria = true;
            }
        }
        
        if (animais.isEmpty()) {
            System.out.println("Não há pacientes para a consulta.");
            return;
        }
        if (!temMedico) {
            System.out.println("Não há médico para realizar a consulta");
            return;
        }
        
        System.out.print("Digite a data da consulta: ");
        c.setDataConsulta(teclado.nextLine());
        
        listarVeterinarios();
        int idx = getInt("Selecione o Médico: ");
        c.setVeterinario((Veterinario) funcionarios.get(idx));
        teclado.nextLine();
        
        listarAnimais();
        idx = getInt("Selecione o Paciente: ");
        c.setAnimal(animais.get(idx));
        teclado.nextLine();
        
        if(temSecretaria){
            listarSecretarias();
            idx = getInt("Selecione o índice da Secretaria: ");
            c.setSecretaria((Secretaria) funcionarios.get(idx));
            teclado.nextLine();
        }
        consultas.add(c);
        System.out.println("Agendamento realizado com sucesso!");
    }
    
    private void cadastrarVeterinario(){
        Veterinario funcionario = new Veterinario();
        teclado.nextLine();
        lerNome(funcionario);
        lerCpf(funcionario);
        
        System.out.print("Digite o CRMV: ");
        String crmv = teclado.nextLine();
        funcionario.setCrmv(crmv);
        
        System.out.print("Digite a Especialidade: ");
        String especialidade = teclado.nextLine();
        funcionario.setEspecialidade(especialidade);
        
        System.out.print("Digite o salário: ");
        float salario = teclado.nextFloat();
        funcionario.setSalario(salario);
        teclado.nextLine();
        
        funcionarios.add(funcionario);
        System.out.println("Cadastramento realizado com sucesso!");
    }
    
    private void cadastrarSecretaria(){
        Secretaria funcionario = new Secretaria();
        teclado.nextLine();
        lerNome(funcionario);
        lerCpf(funcionario);
        
        System.out.print("Digite o email: ");
        String email = teclado.nextLine();
        funcionario.setEmail(email);
        
        System.out.print("Digite o telefone: ");
        String telefone = teclado.nextLine();
        funcionario.setTelefone(telefone);
        
        System.out.print("Digite a data de nascimento: ");
        String data = teclado.nextLine();
        funcionario.setDataNascimento(data);
        
        System.out.print("Digite o salário: ");
        float salario = teclado.nextFloat();
        funcionario.setSalario(salario);
        teclado.nextLine();
        
        funcionarios.add(funcionario);
        System.out.println("Cadastramento realizado com sucesso!");
    }
    
    private void registrarResgate(){
        Animal animal = new Animal();
        teclado.nextLine();
        lerNome(animal);
        
        System.out.print("Digite a especie: ");
        String especie = teclado.nextLine();
        animal.setEspecie(especie);
        
        System.out.print("Digite a raça: ");
        String raca = teclado.nextLine();
        animal.setRaca(raca);

        int idade = getInt("Digite a idade em meses: ");
        animal.setIdade(idade);
        teclado.nextLine();
        
        System.out.print("Digite o status: ");
        String status = teclado.nextLine();
        animal.setStatus(status);
        
        animais.add(animal);
        
        Resgate resgate = new Resgate();
        System.out.print("Data do Resgate: ");
        resgate.setDataResgate(teclado.nextLine());

        resgate.setAnimal(animal); 
        resgates.add(resgate); 
        System.out.println("Registramento realizado com sucesso!");
    }
    
    private void registrarAdocao(){
        boolean animalDisponivel = false;
        for (Animal a : animais) {
            if (!a.getStatus().equalsIgnoreCase("Adotado")) {
               animalDisponivel = true;
                break;
            }
        }
        if (!animalDisponivel) {
            System.out.println("Nenhum animal para adoção encontrado");
            return; 
        }
        
        listarAnimais(); 
        int idx = getInt("Selecione o índice do animal que será adotado: ");
        Animal animal = animais.get(idx);
        
        Adocao adocao = new Adocao();
        teclado.nextLine();
        
        System.out.print("Digite o nome do adotante: ");
        String adotante = teclado.nextLine();
        adocao.setAdotante(adotante);
        
        System.out.print("Digite a data da adoção: ");
        String dataAdocao = teclado.nextLine();
        adocao.setDataAdocao(dataAdocao);
        
        adocao.setAnimal(animal);
        animal.setStatus("Adotado");
        
        adocoes.add(adocao);
        System.out.println("Registramento realizado com sucesso!");
    }
}