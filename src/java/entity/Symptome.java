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
@Table(name = "symptome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Symptome.findAll", query = "SELECT s FROM Symptome s")
    , @NamedQuery(name = "Symptome.findByIdSymptome", query = "SELECT s FROM Symptome s WHERE s.idSymptome = :idSymptome")
    , @NamedQuery(name = "Symptome.findByNomS", query = "SELECT s FROM Symptome s WHERE s.nomS = :nomS")})
public class Symptome implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdSymptome")
    private Integer idSymptome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NomS")
    private String nomS;
    @ManyToMany(mappedBy = "symptomeCollection")
    private Collection<Patient> patientCollection;

    public Symptome() {
    }

    public Symptome(Integer idSymptome) {
        this.idSymptome = idSymptome;
    }

    public Symptome(Integer idSymptome, String nomS) {
        this.idSymptome = idSymptome;
        this.nomS = nomS;
    }

    public Integer getIdSymptome() {
        return idSymptome;
    }

    public void setIdSymptome(Integer idSymptome) {
        this.idSymptome = idSymptome;
    }

    public String getNomS() {
        return nomS;
    }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSymptome != null ? idSymptome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Symptome)) {
            return false;
        }
        Symptome other = (Symptome) object;
        if ((this.idSymptome == null && other.idSymptome != null) || (this.idSymptome != null && !this.idSymptome.equals(other.idSymptome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Symptome[ idSymptome=" + idSymptome + " ]";
    }
    
}
