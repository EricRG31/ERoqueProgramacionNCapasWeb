/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.Controller;

import com.digis01.ERoqueProgramacionNCapasWeb.DAO.TipoInmuebleDAOImplementation;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.TipoInmueble;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/inmobilario")
public class TipoInmuebleController {
    
    private TipoInmuebleDAOImplementation tipoInmuebleDAOImplementation;
    
    @Autowired
    public TipoInmuebleController(TipoInmuebleDAOImplementation tipoInmuebleDAOImplementation){
    this.tipoInmuebleDAOImplementation = tipoInmuebleDAOImplementation;
    }
    
    @GetMapping("/listado")
    private String listadoInmueble(Model model){
        List<TipoInmueble> tipoInmuebles = tipoInmuebleDAOImplementation.GetAll();
        model.addAttribute("TipoInmuebles", tipoInmuebles);
        model.addAttribute("TipoInmueble", new TipoInmueble());
        return "listadoInmuebles";
    }
    
    
    
    @GetMapping("/form/{idtipoinmueble}")
    public String Form(@PathVariable int idtipoinmueble, Model model){
    
        if(idtipoinmueble == 0){
        model.addAttribute("tipoinmueble", new TipoInmueble());
        return "formtipoinmueble";
        }else{
        TipoInmueble tipoinmueble = new TipoInmueble();
        tipoinmueble = tipoInmuebleDAOImplementation.GetById(idtipoinmueble);
        model.addAttribute("tipoinmueble", tipoinmueble);
       
        return "formtipoinmueble";
        }
    }
    
    @PostMapping("/form")
    public String Update(@ModelAttribute TipoInmueble tipoInmueble){
        
        if(tipoInmueble.getIdtipoinmueble() > 0){
        tipoInmuebleDAOImplementation.Update(tipoInmueble);
        }else{
        tipoInmuebleDAOImplementation.Add(tipoInmueble);
        return"redirect:/inmobilario/listado";
        }
    
    return"redirect:/inmobilario/listado";
    }
    
    
    @GetMapping("/eliminarInmueble/{idtipoinmueble}")
    public String Delete(@PathVariable int idtipoinmueble, Model model) {

        TipoInmueble tipoInmueble = tipoInmuebleDAOImplementation.GetById(idtipoinmueble);

        model.addAttribute("tipoInmueble", tipoInmueble);
        tipoInmuebleDAOImplementation.Delete(tipoInmueble);

        
        return "redirect:/inmobilario/listado";
    }
    
}
 