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
import javax.persistence.Id;
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
@Table(name = "pathologie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pathologie.findAll", query = "SELECT p FROM Pathologie p")
    , @NamedQuery(name = "Pathologie.findByNomP", query = "SELECT p FROM Pathologie p WHERE p.nomP = :nomP")})
public class Pathologie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NomP")
    private String nomP;
    @ManyToMany(mappedBy = "pathologieCollection")
    private Collection<Patient> patientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomP")
    private Collection<Traitement> traitementCollection;

    public Pathologie() {
    }

    public Pathologie(String nomP) {
        this.nomP = nomP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    @XmlTransient
    public Collection<Traitement> getTraitementCollection() {
        return traitementCollection;
    }

    public void setTraitementCollection(Collection<Traitement> traitementCollection) {
        this.traitementCollection = traitementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomP != null ? nomP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pathologie)) {
            return false;
        }
        Pathologie other = (Pathologie) object;
        if ((this.nomP == null && other.nomP != null) || (this.nomP != null && !this.nomP.equals(other.nomP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pathologie[ nomP=" + nomP + " ]";
    }
    
}
