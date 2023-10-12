/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.DAO;

import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Rol;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class UsuarioDAOImplementation implements IUsuarioDAO {
    
    
    
    private EntityManager entityManager;
    
    @Autowired
    public UsuarioDAOImplementation(EntityManager entityManager){
    this.entityManager = entityManager;
    }
    
    

    @Override
    public List<Usuario> GetAll(Usuario usuario) {
        
        //Investigar Lenguaje JPQL 
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE UPPER (nombre) LIKE UPPER (:nombreusuario) AND UPPER (apellidopaterno) LIKE UPPER (:apellidopaterno) AND UPPER (apellidomaterno) LIKE UPPER (:apellidomaterno)", Usuario.class);
        query.setParameter("nombreusuario",('%' + usuario.getNombre().trim()) + '%');
         query.setParameter("apellidopaterno",('%' + usuario.getApellidopaterno().trim()) + '%');
          query.setParameter("apellidomaterno",('%' + usuario.getApellidomaterno().trim()) + '%');
        List<Usuario> usuarios = query.getResultList();
        
        return usuarios;
    }

    @Override
    @Transactional
    public int Add(Usuario usuario) {
        entityManager.persist(usuario);
        
        return usuario.getIdusuario();
    }

    @Override
    public Usuario GetById(int idUsuarioEditable) {
     TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE idusuario =:idUsuarioEditable",Usuario.class);
     query.setParameter("idUsuarioEditable",idUsuarioEditable);
     
     return query.getSingleResult();
    }

    @Override
    @Transactional
    public void Update(Usuario usuario) {
        entityManager.merge(usuario);
        
    }
    
    

    @Override
    @Transactional
    public void Delete(Usuario usuario) {
        
        
        entityManager.remove(usuario);
    }

    @Override
    @Transactional
    public void ChangeStatus(int idUsuario, boolean status) {
        Usuario usuario = entityManager.find(Usuario.class, idUsuario);
        String statusString = (status)?  "Y" : "N"; //Operador Ternario
        usuario.setStatus(statusString);
        entityManager.merge(usuario);

    }

    
    
    

    
    
}

//List<Usuario> usuarios = new ArrayList<>();
//        try{
//            TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario",Usuario.class);
//            usuarios = query.getResultList();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
