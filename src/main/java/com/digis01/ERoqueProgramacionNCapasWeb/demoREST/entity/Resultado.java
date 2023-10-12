/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.demoREST.entity;

/**
 *
 * @author digis
 */
public class Resultado {
        private double respuesta;
        private String Respuestas;

    public Resultado(double respuesta) {
        this.respuesta = respuesta;
    }

    public double getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(double respuesta) {
        this.respuesta = respuesta;
    }

    public Resultado(double respuesta, String Respuestas) {
        this.respuesta = respuesta;
        this.Respuestas = Respuestas;
    }

    public String getRespuestas() {
        return Respuestas;
    }

    public void setRespuestas(String Respuestas) {
        this.Respuestas = Respuestas;
    }

    
        
        
}
