/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.ExamenFacadeLocal;
import dao.PatientFacadeLocal;
import entity.Examen;
import entity.Patient;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author kelly
 */
@Named(value = "viewPatient")
@SessionScoped
public class ViewPatient implements Serializable {
@EJB
PatientFacadeLocal monPatientDao;
@EJB
ExamenFacadeLocal monExamenDao;
Patient monPatient;
Patient AncienPatient;
Patient NouveauPatient;
Examen NouveauExamen;
Examen monExamen;
Examen AncienExamen;
private Integer id;
private Integer idPat;
private Integer idExamenSupp;
private Integer idExamenMod;
private String NomP;
private String PrenomP;

/**
     * Creates a new instance of ViewPatient
     */
    public ViewPatient() {
        monPatient = new Patient();
        AncienPatient = new Patient();
        NouveauPatient = new Patient();
        NouveauExamen = new Examen();
    }
    
    public Patient getMonPatient() {
        return monPatient;
    }

    public void setMonPatient(Patient monPatient) {
        this.monPatient = monPatient;
    }
    
    public Patient getAncienPatient() {
        return AncienPatient;
    }

    public void setAncienPatient(Patient AncienPatient) {
        this.AncienPatient = AncienPatient;
    }

    public Patient getNouveauPatient() {
        return NouveauPatient;
    }

    public void setNouveauPatient(Patient NouveauPatient) {
        this.NouveauPatient = NouveauPatient;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPat() {
        return idPat;
    }

    public void setIdPat(Integer idPat) {
        this.idPat = idPat;
    }

    public Examen getNouveauExamen() {
        return NouveauExamen;
    }

    public void setNouveauExamen(Examen NouveauExamen) {
        this.NouveauExamen = NouveauExamen;
    }
    
    public Examen getMonExamen() {
        return monExamen;
    }

    public void setMonExamen(Examen monExamen) {
        this.monExamen = monExamen;
    }
    
    
    public Examen getAncienExamen() {
        return AncienExamen;
    }

    public void setAncienExamen(Examen AncienExamen) {
        this.AncienExamen = AncienExamen;
    }

    public Integer getIdExamenSupp() {
        return idExamenSupp;
    }

    public void setIdExamenSupp(Integer idExamenSupp) {
        this.idExamenSupp = idExamenSupp;
    }

    public Integer getIdExamenMod() {
        return idExamenMod;
    }

    public void setIdExamenMod(Integer idExamenMod) {
        this.idExamenMod = idExamenMod;
    }
    
    public String getNomP() {
        return NomP;
    }

    public void setNomP(String NomP) {
        this.NomP = NomP;
    }

    public String getPrenomP() {
        return PrenomP;
    }

    public void setPrenomP(String PrenomP) {
        this.PrenomP = PrenomP;
    }
    
    /****************************************************** PATIENT ***************************************/
    
    /**
     * Fonction qui retourne la liste des patients qui sont dans la base de données -- Avec Primefaces 
     */
    public List<Patient> getListe(){
        return monPatientDao.findAll();
    }
    
    /**
     * Fonction qui ajoute des patients
     */
    public void addPatient(){
    monPatientDao.create(monPatient);
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage("Successful",  "Le nouveau Patient a bien été ajouté"));
  }
  
    /**
     * Fonction qui supprime des patients
     */
     public void deletePatient(){
     monPatient = monPatientDao.find(id); 
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage(null, new FacesMessage("Successful",  "Le Patient "+ monPatient.getNomPatient()+ " " + monPatient.getPrenomPatient()+ " a bien été supprimé"));
     monPatientDao.remove(monPatient);
     
    }
     
    /**
     * Fonction qui modifie le nom des patients
     */
  public void editNomPatient(){
      AncienPatient = monPatientDao.find(idPat); 
      AncienPatient.setNomPatient(NouveauPatient.getNomPatient());  
      monPatientDao.edit(AncienPatient);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage("Successful",  "Modifications réalisés avec succès. Voici le nouveau nom du patient : "+ NouveauPatient.getNomPatient()));
  }
    /**
     * Fonction qui modifie le prénom des patients
     */
  public void editPrenomPatient(){
      AncienPatient = monPatientDao.find(idPat);   
      AncienPatient.setPrenomPatient(NouveauPatient.getPrenomPatient());
      monPatientDao.edit(AncienPatient);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage("Successful",  "Modifications réalisés avec succès. Voici le nouveau prénom du patient : "+ NouveauPatient.getPrenomPatient()));
  }
  
  /***************************************************** EXAMEN ***************************************/

    /**
     * Fonction qui retourne la liste des examens qui sont dans la base de données -- Avec Primefaces 
     */
    public List<Examen> getListeExam(){
        return monExamenDao.findAll();
    }

    /**
     * Fonction qui ajoute des examens
     */
    public void addExamen(){
    List<Patient> Patient = monPatientDao.findAll();
    FacesContext context = FacesContext.getCurrentInstance();
    for (int i=0;i<Patient.size();i++){
        if (Patient.get(i).getNomPatient().equals(monPatient.getNomPatient()) && Patient.get(i).getPrenomPatient().equals(monPatient.getPrenomPatient())){
            NouveauExamen.setIdPatient(Patient.get(i));
            monExamenDao.create(NouveauExamen);
            context.addMessage(null, new FacesMessage("Successful",  "L'examen a bien été ajouté"));
        }
    }

    }

     /**
     * Fonction qui supprime des examens
     */
     public void deleteExamen(){
     monExamen = monExamenDao.find(idExamenSupp); 
     FacesContext context = FacesContext.getCurrentInstance();
     context.addMessage(null, new FacesMessage("Successful",  "L'examen a bien été supprimé"));
     monExamenDao.remove(monExamen);
     
    }

    /**
     * Fonction qui modifie le nom de l'examen
     */
  public void editNomExamen(){
      AncienExamen = monExamenDao.find(idExamenMod); 
      AncienExamen.setNomE(NouveauExamen.getNomE());  
      monExamenDao.edit(AncienExamen);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage("Successful",  "Modifications réalisés avec succès. Voici le nouveau nom de l'examen : "+ NouveauExamen.getNomE()));
  }
    /**
     * Fonction qui modifie le resultat de l'examen
     */
  public void editResultatExamen(){
      AncienExamen = monExamenDao.find(idExamenMod); 
      AncienExamen.setResultats(NouveauExamen.getResultats());  
      monExamenDao.edit(AncienExamen);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage("Successful",  "Modifications réalisés avec succès. Voici le nouveau résultat de l'examen : "+ NouveauExamen.getResultats()));
  }

     /**
     * Fonction qui modifie le resultat de l'examen
     */
  public void editIdPatientExam(){
    AncienExamen = monExamenDao.find(idExamenMod); 
    NouveauPatient = monPatientDao.find(id);
    AncienExamen.setIdPatient(NouveauPatient);  
    monExamenDao.edit(AncienExamen);
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage("Successful",  "Modifications réalisés avec succès"));
  }

}