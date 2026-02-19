/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.mycompany.sistemaabrigoanimais.persistencia.*;
/**
 *
 * @author Giovana
 */
public class Menu {
    private int opcao;
    private Scanner teclado = new Scanner(System.in);
    
    private IAnimalDAO animalDAO = new AnimalDAOImplPostgres();
    private ISecretariaDAO secretariaDAO = new SecretariaDAOImplPostgres();
    private IVeterinarioDAO veterinarioDAO = new VeterinarioDAOImplPostgres();
    private IConsultaDAO consultaDAO = new ConsultaDAOImplPostgres();
    private IResgateDAO resgateDAO = new ResgateDAOImplPostgres();
    private IAdocaoDAO adocaoDAO = new AdocaoDAOImplPostgres();
    
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
        List<Consulta> lista = consultaDAO.consultar();
        
        if(lista.isEmpty()){
            System.out.println("Nenhuma consulta encontrada.");
        }
        for (Consulta c : lista) {
            System.out.println(c.getId() + " " + c.toString());            
        }
    }
    
    private void listarAnimais(){
        List<Animal> lista = animalDAO.consultar();
        
        for (Animal a : lista) {
            if (!a.getStatus().equalsIgnoreCase("Adotado")){
                System.out.println(a.getId() + " " + a.toString()); 
            }         
        }
    }
    
    private void listarVeterinarios(){
        List<Veterinario> lista = veterinarioDAO.consultar();
        for (Veterinario v : lista) {
                System.out.println(v.getId() + " " + v.toString());           
        } 
    }
    
    private void listarSecretarias(){
        List<Secretaria> lista = secretariaDAO.consultar();
        for (Secretaria s : lista) {
                System.out.println(s.getId() + " " + s.toString());           
        }
    }
    
    private void listarResgates(){
        System.out.println("\n--- Resgates realizados ---");
        List<Resgate> lista = resgateDAO.consultar();
        
        if(lista.isEmpty()){
            System.out.println("Nenhum resgate encontrada.");
        }
        for (Resgate r : lista) {
            System.out.println(r.getId() + " " + r.toString());            
        }
    }
    
    private void listarAdocoes(){
        System.out.println("\n--- Adoções realizados ---");
        List<Adocao> lista = adocaoDAO.consultar();
        
        if(lista.isEmpty()){
            System.out.println("Nenhuma adoção encontrada.");
        }
        for (Adocao a : lista) {
            System.out.println(a.getId() + " " + a.toString());            
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
        List<Veterinario> listaV = veterinarioDAO.consultar();
        List<Animal> listaA = animalDAO.consultar();
        
        if (listaA.isEmpty()) {
            System.out.println("Não há pacientes para a consulta.");
            return;
        }
        if (listaV.isEmpty()) {
            System.out.println("Não há médico para realizar a consulta");
            return;
        }
        
        Consulta c = new Consulta();
        teclado.nextLine(); 

        System.out.print("Digite a data da consulta: ");
        c.setDataConsulta(teclado.nextLine());
        
        listarVeterinarios();
        int idx = getInt("Selecione o Veterinário: ");
            for (Veterinario v : listaV) {
            if (v.getId() == idx) {
                c.setVeterinario(v);
            }
        }
        
        listarAnimais();
        idx = getInt("Selecione o Paciente: ");
        for (Animal a : listaA) {
            if (a.getId() == idx) {
                c.setAnimal(a);
            }
        }
        
        List<Secretaria> listaS = secretariaDAO.consultar();
        if(!listaS.isEmpty()){
            listarSecretarias();
            idx = getInt("Selecione o índice da Secretaria: ");
            for (Secretaria s : listaS) {
                if (s.getId() == idx) {
                    c.setSecretaria(s);
                }
            }
        }
        consultaDAO.inserir(c);
        System.out.println("Agendamento realizado com sucesso!");
    }
    
    private void cadastrarVeterinario(){
        Veterinario v = new Veterinario();
        teclado.nextLine();
        lerNome(v);
        lerCpf(v);
        
        System.out.print("Digite o CRMV: ");
        String crmv = teclado.nextLine();
        v.setCrmv(crmv);
        
        System.out.print("Digite a Especialidade: ");
        String especialidade = teclado.nextLine();
        v.setEspecialidade(especialidade);
        
        System.out.print("Digite o salário: ");
        float salario = teclado.nextFloat();
        v.setSalario(salario);
        teclado.nextLine();
        
        veterinarioDAO.inserir(v);
        System.out.println("Cadastramento realizado com sucesso!");
    }
    
    private void cadastrarSecretaria(){
        Secretaria s = new Secretaria();
        teclado.nextLine();
        lerNome(s);
        lerCpf(s);
        
        System.out.print("Digite o email: ");
        String email = teclado.nextLine();
        s.setEmail(email);
        
        System.out.print("Digite o telefone: ");
        String telefone = teclado.nextLine();
        s.setTelefone(telefone);
        
        System.out.print("Digite a data de nascimento: ");
        String data = teclado.nextLine();
        s.setDataNascimento(data);
        
        System.out.print("Digite o salário: ");
        float salario = teclado.nextFloat();
        s.setSalario(salario);
        teclado.nextLine();
        
        secretariaDAO.inserir(s);
        System.out.println("Cadastramento realizado com sucesso!");
    }
    
    private void registrarResgate(){
        Animal a = new Animal();
        teclado.nextLine();
        lerNome(a);
        
        System.out.print("Digite a especie: ");
        String especie = teclado.nextLine();
        a.setEspecie(especie);
        
        System.out.print("Digite a raça: ");
        String raca = teclado.nextLine();
        a.setRaca(raca);

        int idade = getInt("Digite a idade em meses: ");
        a.setIdade(idade);
        teclado.nextLine();
        
        System.out.print("Digite o status: ");
        String status = teclado.nextLine();
        a.setStatus(status);
        
        animalDAO.inserir(a);
        List<Animal> lista = animalDAO.consultar();
        Animal animal = lista.get(lista.size() - 1);
        
        Resgate r = new Resgate();
        System.out.print("Data do Resgate: ");
        r.setDataResgate(teclado.nextLine());

        r.setAnimal(animal); 
        resgateDAO.inserir(r); 
        System.out.println("Registramento realizado com sucesso!");
    }
    
    private void registrarAdocao(){
        boolean animalDisponivel = false;
        List<Animal> lista = animalDAO.consultar();
        
        for (Animal a : lista) {
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
        Animal animal = null;
        for (Animal a : lista){
            if(a.getId() == idx){
                animal = a;
                break;
            }
        }
        if (animal == null) {
            System.out.println("ID não encontrado!");
            return;
        }
        Adocao adocao = new Adocao();
        teclado.nextLine();
        
        System.out.print("Digite o nome do adotante: ");
        String adotante = teclado.nextLine();
        adocao.setAdotante(adotante);
        
        System.out.print("Digite a data da adoção: ");
        String dataAdocao = teclado.nextLine();
        adocao.setDataAdocao(dataAdocao);
        
        adocao.setAnimal(animal);
        adocaoDAO.inserir(adocao);
        animal.setStatus("Adotado");
        animalDAO.atualizar(animal);
        
        System.out.println("Registramento realizado com sucesso!");
    }
}