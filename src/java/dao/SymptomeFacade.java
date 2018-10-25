/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Symptome;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kelly
 */
@Stateless
public class SymptomeFacade extends AbstractFacade<Symptome> implements SymptomeFacadeLocal {

    @PersistenceContext(unitName = "ChelouPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SymptomeFacade() {
        super(Symptome.class);
    }
    
}
