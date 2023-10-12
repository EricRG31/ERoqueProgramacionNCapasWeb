/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.DAO;

import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Direccion;
import com.digis01.ERoqueProgramacionNCapasWeb.JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class DireccionDAOImplementation implements IDireccionDAO {
    
    private EntityManager entityManager;

    @Autowired // inyección
    public DireccionDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    
    public List<Direccion> GetAll(){
        
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion", Direccion.class);
        List<Direccion> direcciones = query.getResultList();
        
        return direcciones;
    }
    
    @Override
    @Transactional
    public void Add(Direccion direccion) {
        entityManager.persist(direccion);
    }
    
    @Override
    public Direccion GetByIdColonia(int idDireccionEditable) {
     TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion WHERE colonia.idusuario =:idDireccionEditable",Direccion.class);
     query.setParameter("idDireccionEditable",idDireccionEditable);
     
     return query.getSingleResult();
    }

    @Override
    @Transactional
    public void Update(Direccion direccion) {
        entityManager.merge(direccion);
        
    }

    @Override
    public Direccion GetByIdUsuario(int idUsuario) {
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion WHERE usuario.idusuario=:idUsuario", Direccion.class);
        query.setParameter("idUsuario", idUsuario);
        Direccion direccion = query.getSingleResult();
        return direccion;
    }
    
}
