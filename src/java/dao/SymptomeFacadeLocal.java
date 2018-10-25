/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Symptome;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kelly
 */
@Local
public interface SymptomeFacadeLocal {

    void create(Symptome symptome);

    void edit(Symptome symptome);

    void remove(Symptome symptome);

    Symptome find(Object id);

    List<Symptome> findAll();

    List<Symptome> findRange(int[] range);

    int count();
    
}
