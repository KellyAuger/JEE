/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Traitement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kelly
 */
@Stateless
public class TraitementFacade extends AbstractFacade<Traitement> implements TraitementFacadeLocal {

    @PersistenceContext(unitName = "ChelouPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TraitementFacade() {
        super(Traitement.class);
    }
    
}
