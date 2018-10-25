/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
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
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
    , @NamedQuery(name = "Patient.findByIdPatient", query = "SELECT p FROM Patient p WHERE p.idPatient = :idPatient")
    , @NamedQuery(name = "Patient.findByNomPatient", query = "SELECT p FROM Patient p WHERE p.nomPatient = :nomPatient")
    , @NamedQuery(name = "Patient.findByPrenomPatient", query = "SELECT p FROM Patient p WHERE p.prenomPatient = :prenomPatient")})
public class Patient implements Serializable {

    @JoinTable(name = "souffrede", joinColumns = {
        @JoinColumn(name = "IdPatient", referencedColumnName = "IdPatient")}, inverseJoinColumns = {
        @JoinColumn(name = "NomP", referencedColumnName = "NomP")})
    @ManyToMany
    private Collection<Pathologie> pathologieCollection;
    @JoinTable(name = "possede", joinColumns = {
        @JoinColumn(name = "IdPatient", referencedColumnName = "IdPatient")}, inverseJoinColumns = {
        @JoinColumn(name = "IdSymptome", referencedColumnName = "IdSymptome")})
    @ManyToMany
    private Collection<Symptome> symptomeCollection;
    @ManyToMany(mappedBy = "patientCollection")
    private Collection<Medecin> medecinCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatient")
    private Collection<Traitement> traitementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatient")
    private Collection<Examen> examenCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPatient")
    private Integer idPatient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NomPatient")
    private String nomPatient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PrenomPatient")
    private String prenomPatient;

    public Patient() {
    }

    public Patient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Patient(Integer idPatient, String nomPatient, String prenomPatient) {
        this.idPatient = idPatient;
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getPrenomPatient() {
        return prenomPatient;
    }

    public void setPrenomPatient(String prenomPatient) {
        this.prenomPatient = prenomPatient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPatient != null ? idPatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.idPatient == null && other.idPatient != null) || (this.idPatient != null && !this.idPatient.equals(other.idPatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Patient[ idPatient=" + idPatient + " ]";
    }

    @XmlTransient
    public Collection<Pathologie> getPathologieCollection() {
        return pathologieCollection;
    }

    public void setPathologieCollection(Collection<Pathologie> pathologieCollection) {
        this.pathologieCollection = pathologieCollection;
    }

    @XmlTransient
    public Collection<Symptome> getSymptomeCollection() {
        return symptomeCollection;
    }

    public void setSymptomeCollection(Collection<Symptome> symptomeCollection) {
        this.symptomeCollection = symptomeCollection;
    }

    @XmlTransient
    public Collection<Medecin> getMedecinCollection() {
        return medecinCollection;
    }

    public void setMedecinCollection(Collection<Medecin> medecinCollection) {
        this.medecinCollection = medecinCollection;
    }

    @XmlTransient
    public Collection<Traitement> getTraitementCollection() {
        return traitementCollection;
    }

    public void setTraitementCollection(Collection<Traitement> traitementCollection) {
        this.traitementCollection = traitementCollection;
    }

    @XmlTransient
    public Collection<Examen> getExamenCollection() {
        return examenCollection;
    }

    public void setExamenCollection(Collection<Examen> examenCollection) {
        this.examenCollection = examenCollection;
    }
    
}
