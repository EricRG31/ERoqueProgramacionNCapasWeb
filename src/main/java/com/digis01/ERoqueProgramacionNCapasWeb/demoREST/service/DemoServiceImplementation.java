/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.demoREST.service;

import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Usuario;
import com.digis01.ERoqueProgramacionNCapasWeb.demoREST.entity.NumerosOperacion;
import com.digis01.ERoqueProgramacionNCapasWeb.demoREST.entity.Resultado;

/**
 *
 * @author digis
 */
public class DemoServiceImplementation implements IDemoServicio {

    @Override
    public Resultado Suma(NumerosOperacion numerosOperacion) {
        return new Resultado(numerosOperacion.getNumero1() + numerosOperacion.getNumero2());
    }

    @Override
    public Resultado Resta(NumerosOperacion numerosOperacion) {
        return new Resultado(numerosOperacion.getNumero1() - numerosOperacion.getNumero2());
    }

    @Override
    public Resultado Multiplicacion(NumerosOperacion numerosOperacion) {
        return new Resultado(numerosOperacion.getNumero1() * numerosOperacion.getNumero2());
    }

    @Override
    public Resultado Division(NumerosOperacion numerosOperacion) {
        return new Resultado(numerosOperacion.getNumero1() / numerosOperacion.getNumero2());
    }

    @Override
    public String Saludo(String nombre) {
        return "Hola, " + nombre;
    }

    @Override
    public Usuario Busqueda(Usuario usuario) {
        return new Usuario();
    }
    
    

   
    

}
