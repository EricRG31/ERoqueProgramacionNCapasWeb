/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.demoREST.controller;

import com.digis01.ERoqueProgramacionNCapasWeb.demoREST.entity.NumerosOperacion;
import com.digis01.ERoqueProgramacionNCapasWeb.demoREST.entity.Resultado;
import com.digis01.ERoqueProgramacionNCapasWeb.demoREST.service.DemoServiceImplementation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/api")
public class DemoControllerapi {
 
    
    @PostMapping("/suma")
    public Resultado suma(@RequestBody NumerosOperacion numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Suma(numeros);
    }   
    
    @PostMapping("/resta")
    public Resultado resta(@RequestBody NumerosOperacion numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Resta(numeros);
    }
    
    @PostMapping("/multiplicacion")
    public Resultado multiplicacion(@RequestBody NumerosOperacion numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Multiplicacion(numeros);
    }
    
    @PostMapping("/division")
    public Resultado division(@RequestBody NumerosOperacion numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Division(numeros);
    }
    
    @GetMapping("/saludo")
    public Map<String, Object> Saludo() {
        Map<String,Object> response = new HashMap<>();
        response.put("Saludo", "Hola mundo");
        return response;
    }
    
    
}
