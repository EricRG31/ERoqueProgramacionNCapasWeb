/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.demoREST.controller;

import com.digis01.ERoqueProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Usuario;
import com.digis01.ERoqueProgramacionNCapasWeb.demoREST.service.DemoServiceImplementation;
import java.util.List;
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
@RequestMapping("/usuarioApi")
public class UsuarioRestController {
    
    private UsuarioDAOImplementation usuarioDAOImplementation;

    public UsuarioRestController(UsuarioDAOImplementation usuarioDAOImplementation) {
        this.usuarioDAOImplementation = usuarioDAOImplementation;
    }
    
    @GetMapping("/GetAll")
    public List<Usuario> GetALL(){
        return usuarioDAOImplementation.GetAll(new Usuario("", "", ""));
    }
    
    @PostMapping("/busqueda")
    public Usuario busqueda (@RequestBody Usuario usuario) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Busqueda(usuario);
    }
    
    
}
