/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.demoREST.service;

import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Usuario;
import com.digis01.ERoqueProgramacionNCapasWeb.demoREST.entity.NumerosOperacion;
import com.digis01.ERoqueProgramacionNCapasWeb.demoREST.entity.Resultado;

/**
 *
 * @author digis
 */
public interface IDemoServicio {
    
    Resultado Suma(NumerosOperacion numerosOperacion);
    Resultado Resta(NumerosOperacion numerosOperacion);
    Resultado Multiplicacion(NumerosOperacion numerosOperacion);
    Resultado Division(NumerosOperacion numerosOperacion);
    
    String Saludo(String nombre);
    
    Usuario Busqueda(Usuario usuario);
}
