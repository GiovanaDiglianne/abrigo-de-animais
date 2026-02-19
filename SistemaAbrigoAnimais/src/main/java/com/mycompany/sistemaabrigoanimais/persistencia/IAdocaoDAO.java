/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.List;
import com.mycompany.sistemaabrigoanimais.Adocao;

/**
 *
 * @author Giovana
 */
public interface IAdocaoDAO {
    public void inserir(Adocao adocao);
    public List<Adocao> consultar();
    public void atualizar(Adocao adocao);
    public void remover(Adocao adocao);
}
