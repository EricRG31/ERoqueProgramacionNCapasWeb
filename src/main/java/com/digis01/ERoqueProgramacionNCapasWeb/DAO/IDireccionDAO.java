/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.DAO;

import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Direccion;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Usuario;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IDireccionDAO {
    
    List<Direccion> GetAll();
    
    void Add(Direccion direccion);

    Direccion GetByIdColonia (int idDireccionEditable);
   
   void Update(Direccion direccion);
   
   Direccion GetByIdUsuario(int IdUsuario);
    
    
}
