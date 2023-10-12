/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.Controller;

import com.digis01.ERoqueProgramacionNCapasWeb.DAO.ServicioDAOImplementation;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Servicio;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author digis
 */

@Controller
@RequestMapping("/servicio")
public class ServicioController {
    
    private ServicioDAOImplementation servicioDAOImplementation;

    public ServicioController(ServicioDAOImplementation servicioDAOImplementation) {
        this.servicioDAOImplementation = servicioDAOImplementation;
    }
    
    @GetMapping("/listado")
    private String listadoServicio (Model model){
        List<Servicio> servicios= servicioDAOImplementation.GetAll();
        model.addAttribute("Servicios", servicios);
        model.addAttribute("Servicio", new Servicio());
        return "listadoServicios";
    }
    
    @GetMapping("/form/{idservicio}")
    public String Form(@PathVariable int idservicio, Model model){
    
        if(idservicio == 0){
        model.addAttribute("servicio", new Servicio());
        return "formservicio";
        }else{
        Servicio servicio = new Servicio();
        servicio = servicioDAOImplementation.GetById(idservicio);
        model.addAttribute("servicio", servicio);
       
        return "formservicio";
        }
    }
    
    @PostMapping("/form")
    public String Update(@ModelAttribute Servicio servicio){
        
        if(servicio.getIdservicio() > 0){
        servicioDAOImplementation.Update(servicio);
        }else{
        servicioDAOImplementation.Add(servicio);
        return"redirect:/servicio/listado";
        }
    
    return"redirect:/servicio/listado";
    }
    
    @GetMapping("/eliminarServicio/{idservicio}")
    public String Delete(@PathVariable int idservicio, Model model) {

        Servicio servicio = servicioDAOImplementation.GetById(idservicio);

        model.addAttribute("servicio", servicio);
        servicioDAOImplementation.Delete(servicio);

        
        return "redirect:/servicio/listado";
    }
    
    
}
