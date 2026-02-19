/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemaabrigoanimais.persistencia;

import java.util.List;
import com.mycompany.sistemaabrigoanimais.Consulta;

/**
 *
 * @author Giovana
 */
public interface IConsultaDAO {
    public void inserir(Consulta consulta);
    public List<Consulta> consultar();
    public void atualizar(Consulta consulta);
    public void remover(Consulta consulta);
}
