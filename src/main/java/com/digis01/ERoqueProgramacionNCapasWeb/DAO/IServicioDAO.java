/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.DAO;

import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Servicio;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IServicioDAO {
    
    List<Servicio> GetAll();
    
    int Add(Servicio servicio);
    
   Servicio GetById(int idservicioeditable);
    
    void Update (Servicio servicio);
    
    void Delete (Servicio servicio);
}
