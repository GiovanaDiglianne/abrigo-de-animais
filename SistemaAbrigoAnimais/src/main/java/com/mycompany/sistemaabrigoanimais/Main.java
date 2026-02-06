/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemaabrigoanimais;

/**
 *
 * @author Giovana
 */
public class Main {

    public static void main(String[] args) {

        Veterinario vet = new Veterinario("1234-MT", "Dr. Rodrigo", "Cirurgia", 5000.0f);

        Secretaria sec = new Secretaria("Giovana", "(65) 9999-8888", "giovana@email.com", "01/01/2000", 2500.0f);

        Animal dog = new Animal("Thor", "Cachorro", "Golden Retriever", 3, "Resgatado");
        Resgate novoResgate = new Resgate("10/10/2023", dog);

        System.out.println("--- LISTAGEM DE PESSOAL ---");

        vet.imprimir(); 
        sec.imprimir();
        
        System.out.println("\n--- DETALHES DO RESGATE ---");
        System.out.println("Data: " + novoResgate.getDataResgate());
        System.out.println("Animal resgatado: " + novoResgate.getAnimal().getNome() + 
                           " (" + novoResgate.getAnimal().getRaca() + ")");
        
        // Testando a validação de nome que você criou no Funcionario!
        System.out.println("\n--- TESTE DE VALIDAÇÃO ---");
        try {
            sec.setNome("Ana"); // Isso deve disparar a RuntimeException (nome <= 4)
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}
