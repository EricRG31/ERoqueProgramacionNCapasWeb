/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.DAO;

import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Usuario;
import java.util.List;

/**
 *
 * @author digis
 */

//Interface es el contrato
public interface IUsuarioDAO {
    
    
    //Firma del metdo lo que recibira 
    // Retorno . Parametros
    
   List<Usuario> GetAll(Usuario usuario);
    
   int Add(Usuario usuario);
    
    
   Usuario GetById (int idUsuarioEditable);
   
   void Update(Usuario usuario);
   
   void Delete (Usuario usuario);
   
   void ChangeStatus (int idUsuario, boolean status);
   
}
