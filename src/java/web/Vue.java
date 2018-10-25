/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.MedecinFacadeLocal;
import entity.Medecin;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author kelly
 */
@Named(value = "vue")
@SessionScoped
public class Vue implements Serializable {
@EJB
MedecinFacadeLocal monTrucDao;
Medecin monMedecin;
Medecin NouveauMedecin;
Medecin AncienMedecin;
private Integer id;
private Integer idMed;




    /**
     * Creates a new instance of Vue
     */
    public Vue() {
     monMedecin = new Medecin();
     AncienMedecin = new Medecin();
     NouveauMedecin = new Medecin();
    }
   
    /**
     * Fonction qui retourne la liste des médecins qui sont dans la base de données -- Avec Primefaces 
     */
    public List<Medecin> getVraiListe(){
        return monTrucDao.findAll();
    }
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Medecin getMonMedecin() {
        return monMedecin;
    }
    
    public Integer getIdMed() {
        return idMed;
    }

    public void setIdMed(Integer idMed) {
        this.idMed = idMed;
    }


    public void setMonMedecin(Medecin monMedecin) {
        this.monMedecin = monMedecin;
    }
    
    public Medecin getNouveauMedecin() {
        return NouveauMedecin;
    }

    public void setNouveauMedecin(Medecin NouveauMedecin) {
        this.NouveauMedecin = NouveauMedecin;
    }

    public Medecin getAncienMedecin() {
        return AncienMedecin;
    }

    public void setAncienMedecin(Medecin AncienMedecin) {
        this.AncienMedecin = AncienMedecin;
    }

    public String getValeur(){
        Medecin monTruc = monTrucDao.find(1);
        return monTruc.getNomM()+" "+ monTruc.getPrenomM();
    }
    
    /**
     * Fonction qui retourne la liste des médecins qui sont dans la base de données -- sans Primefaces
     */
    public String getListe(){
        String resultat ="";
        List<Medecin> monTruc = monTrucDao.findAll();
        for (int i=0;i<monTruc.size();i++){
         resultat = resultat+" | " + monTruc.get(i).getNomM() + " " + monTruc.get(i).getPrenomM()+ " : " + monTruc.get(i).getTitre();
        } 
        return resultat;
    }
    
  public void AddMedecin(){
    monTrucDao.create(monMedecin);
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage("Successful",  "Le nouveau Médecin a bien été ajouté"));
  }
  
  public void DeleteMedecin(){
     monMedecin = monTrucDao.find(id); 
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage(null, new FacesMessage("Successful",  "Le Médecin "+ monMedecin.getNomM() + " " + monMedecin.getPrenomM()+ " a bien été supprimé"));
     monTrucDao.remove(monMedecin);
     
    }
  public void EditNomMedecin(){
      AncienMedecin = monTrucDao.find(idMed); 
      AncienMedecin.setNomM(NouveauMedecin.getNomM());  
      monTrucDao.edit(AncienMedecin);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage("Successful",  "Modifications réalisés avec succès. Voici le nouveau nom du médecin : "+ NouveauMedecin.getNomM()));
  }
    
  public void EditPrenomMedecin(){
      AncienMedecin = monTrucDao.find(idMed);   
      AncienMedecin.setPrenomM(NouveauMedecin.getPrenomM());
      monTrucDao.edit(AncienMedecin);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage("Successful",  "Modifications réalisés avec succès. Voici le nouveau prénom du médecin : "+ NouveauMedecin.getPrenomM()));
  }
  
   public void EditTitreMedecin(){
      AncienMedecin = monTrucDao.find(idMed); 
      AncienMedecin.setTitre(NouveauMedecin.getTitre());
      monTrucDao.edit(AncienMedecin);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage("Successful",  "Modifications réalisés avec succès. Voici le nouveau titre du médecin : "+ NouveauMedecin.getTitre()));
  }
  
}
