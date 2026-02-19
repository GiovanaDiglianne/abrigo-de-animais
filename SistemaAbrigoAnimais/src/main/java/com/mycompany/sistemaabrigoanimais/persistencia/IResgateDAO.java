/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.List;
import com.mycompany.sistemaabrigoanimais.Resgate;

/**
 *
 * @author Giovana
 */
public interface IResgateDAO {
    public void inserir(Resgate resgate);
    public List<Resgate> consultar();
    public void atualizar(Resgate resgate);
    public void remover(Resgate resgate);
}
