/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ERoqueProgramacionNCapasWeb.DAO;

import com.digis01.ERoqueProgramacionNCapasWeb.JPA.TipoInmueble;
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
public class TipoInmuebleDAOImplementation implements ITipoInmuebleDAO {
    
    private EntityManager entityManager;
    
    @Autowired
    public TipoInmuebleDAOImplementation(EntityManager entityManager){
    this.entityManager = entityManager;
    }


    @Override
    public List<TipoInmueble> GetAll() {
        TypedQuery<TipoInmueble> query = entityManager.createQuery("FROM TipoInmueble",TipoInmueble.class);
        List<TipoInmueble> tipoinmuebles = query.getResultList();
        return tipoinmuebles;
    }

    @Override
    @Transactional
    public int Add(TipoInmueble tipoInmueble) {
        entityManager.persist(tipoInmueble);
        return tipoInmueble.getIdtipoinmueble();
    }

    @Override
    public TipoInmueble GetById(int idtipoinmuebleditable) {
        TypedQuery<TipoInmueble> query = entityManager.createQuery("FROM TipoInmueble WHERE idtipoinmueble =:idtipoinmuebleditable" , TipoInmueble.class);
        query.setParameter("idtipoinmuebleditable", idtipoinmuebleditable);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void Update(TipoInmueble tipoInmueble) {
        entityManager.merge(tipoInmueble);
    }

    @Override
    @Transactional
    public void Delete(TipoInmueble tipoInmueble) {
        entityManager.remove(tipoInmueble);
    }

    

    

    

    

    
    
    
    
    
}
