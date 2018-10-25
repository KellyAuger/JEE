/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kelly
 */
@Entity
@Table(name = "medecin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medecin.findAll", query = "SELECT m FROM Medecin m")
    , @NamedQuery(name = "Medecin.findByIdMedecin", query = "SELECT m FROM Medecin m WHERE m.idMedecin = :idMedecin")
    , @NamedQuery(name = "Medecin.findByNomM", query = "SELECT m FROM Medecin m WHERE m.nomM = :nomM")
    , @NamedQuery(name = "Medecin.findByPrenomM", query = "SELECT m FROM Medecin m WHERE m.prenomM = :prenomM")
    , @NamedQuery(name = "Medecin.findByTitre", query = "SELECT m FROM Medecin m WHERE m.titre = :titre")
    , @NamedQuery(name = "Medecin.findByPhoto", query = "SELECT m FROM Medecin m WHERE m.photo = :photo")
    , @NamedQuery(name = "Medecin.findByNumeroTelephone", query = "SELECT m FROM Medecin m WHERE m.numeroTelephone = :numeroTelephone")})
public class Medecin implements Serializable {

    @JoinTable(name = "ausculte", joinColumns = {
        @JoinColumn(name = "IdMedecin", referencedColumnName = "IdMedecin")}, inverseJoinColumns = {
        @JoinColumn(name = "IdPatient", referencedColumnName = "IdPatient")})
    @ManyToMany
    private Collection<Patient> patientCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdMedecin")
    private Integer idMedecin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NomM")
    private String nomM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PrenomM")
    private String prenomM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Titre")
    private String titre;
    @Size(max = 200)
    @Column(name = "Photo")
    private String photo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumeroTelephone")
    private int numeroTelephone;

    public Medecin() {
    }

    public Medecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
    }

    public Medecin(Integer idMedecin, String nomM, String prenomM, String titre, int numeroTelephone) {
        this.idMedecin = idMedecin;
        this.nomM = nomM;
        this.prenomM = prenomM;
        this.titre = titre;
        this.numeroTelephone = numeroTelephone;
    }

    public Integer getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getNomM() {
        return nomM;
    }

    public void setNomM(String nomM) {
        this.nomM = nomM;
    }

    public String getPrenomM() {
        return prenomM;
    }

    public void setPrenomM(String prenomM) {
        this.prenomM = prenomM;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(int numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedecin != null ? idMedecin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medecin)) {
            return false;
        }
        Medecin other = (Medecin) object;
        if ((this.idMedecin == null && other.idMedecin != null) || (this.idMedecin != null && !this.idMedecin.equals(other.idMedecin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Medecin[ idMedecin=" + idMedecin + " ]";
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }
    
}
