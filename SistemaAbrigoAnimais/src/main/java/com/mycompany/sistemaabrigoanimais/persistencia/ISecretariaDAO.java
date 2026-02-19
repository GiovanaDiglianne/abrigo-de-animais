/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.List;
import com.mycompany.sistemaabrigoanimais.Secretaria;
/**
 *
 * @author Giovana
 */
public interface ISecretariaDAO {
    public void inserir(Secretaria secretaria);
    public List<Secretaria> consultar();
    public void atualizar(Secretaria secretaria);
    public void remover(Secretaria secretaria);
}
