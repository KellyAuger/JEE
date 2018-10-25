/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kelly
 */
@Entity
@Table(name = "traitement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traitement.findAll", query = "SELECT t FROM Traitement t")
    , @NamedQuery(name = "Traitement.findByIdTraitement", query = "SELECT t FROM Traitement t WHERE t.idTraitement = :idTraitement")
    , @NamedQuery(name = "Traitement.findByNomProduit", query = "SELECT t FROM Traitement t WHERE t.nomProduit = :nomProduit")
    , @NamedQuery(name = "Traitement.findByNbUtilisations", query = "SELECT t FROM Traitement t WHERE t.nbUtilisations = :nbUtilisations")
    , @NamedQuery(name = "Traitement.findByDebutTraitement", query = "SELECT t FROM Traitement t WHERE t.debutTraitement = :debutTraitement")
    , @NamedQuery(name = "Traitement.findByFinTraitement", query = "SELECT t FROM Traitement t WHERE t.finTraitement = :finTraitement")})
public class Traitement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdTraitement")
    private Integer idTraitement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NomProduit")
    private String nomProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NbUtilisations")
    private int nbUtilisations;
    @Column(name = "DebutTraitement")
    @Temporal(TemporalType.DATE)
    private Date debutTraitement;
    @Column(name = "FinTraitement")
    @Temporal(TemporalType.DATE)
    private Date finTraitement;
    @JoinColumn(name = "IdPatient", referencedColumnName = "IdPatient")
    @ManyToOne(optional = false)
    private Patient idPatient;
    @JoinColumn(name = "NomP", referencedColumnName = "NomP")
    @ManyToOne(optional = false)
    private Pathologie nomP;

    public Traitement() {
    }

    public Traitement(Integer idTraitement) {
        this.idTraitement = idTraitement;
    }

    public Traitement(Integer idTraitement, String nomProduit, int nbUtilisations) {
        this.idTraitement = idTraitement;
        this.nomProduit = nomProduit;
        this.nbUtilisations = nbUtilisations;
    }

    public Integer getIdTraitement() {
        return idTraitement;
    }

    public void setIdTraitement(Integer idTraitement) {
        this.idTraitement = idTraitement;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getNbUtilisations() {
        return nbUtilisations;
    }

    public void setNbUtilisations(int nbUtilisations) {
        this.nbUtilisations = nbUtilisations;
    }

    public Date getDebutTraitement() {
        return debutTraitement;
    }

    public void setDebutTraitement(Date debutTraitement) {
        this.debutTraitement = debutTraitement;
    }

    public Date getFinTraitement() {
        return finTraitement;
    }

    public void setFinTraitement(Date finTraitement) {
        this.finTraitement = finTraitement;
    }

    public Patient getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Patient idPatient) {
        this.idPatient = idPatient;
    }

    public Pathologie getNomP() {
        return nomP;
    }

    public void setNomP(Pathologie nomP) {
        this.nomP = nomP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTraitement != null ? idTraitement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traitement)) {
            return false;
        }
        Traitement other = (Traitement) object;
        if ((this.idTraitement == null && other.idTraitement != null) || (this.idTraitement != null && !this.idTraitement.equals(other.idTraitement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Traitement[ idTraitement=" + idTraitement + " ]";
    }
    
}
