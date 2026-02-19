/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.List;
import com.mycompany.sistemaabrigoanimais.Veterinario;

/**
 *
 * @author Giovana
 */
public interface IVeterinarioDAO {
    public void inserir(Veterinario veterinario);
    public List<Veterinario> consultar();
    public void atualizar(Veterinario veterinario);
    public void remover(Veterinario veterinario);
}
