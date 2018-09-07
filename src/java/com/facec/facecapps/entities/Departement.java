/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facec.facecapps.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author facec-cr3
 */
@Entity
@Table(name = "departement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d")})
public class Departement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dep_id")
    private Integer depId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "dep_ref")
    private String depRef;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "dep_libelle")
    private String depLibelle;
    @JoinColumn(name = "mat_id", referencedColumnName = "mat_id")
    @ManyToOne(optional = false)
    private Materiel matId;
    @JoinColumn(name = "bureau_id", referencedColumnName = "bureau_id")
    @ManyToOne(optional = false)
    private Bureau bureauId;

    public Departement() {
    }

    public Departement(Integer depId) {
        this.depId = depId;
    }

    public Departement(Integer depId, String depRef, String depLibelle) {
        this.depId = depId;
        this.depRef = depRef;
        this.depLibelle = depLibelle;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepRef() {
        return depRef;
    }

    public void setDepRef(String depRef) {
        this.depRef = depRef;
    }

    public String getDepLibelle() {
        return depLibelle;
    }

    public void setDepLibelle(String depLibelle) {
        this.depLibelle = depLibelle;
    }

    public Materiel getMatId() {
        return matId;
    }

    public void setMatId(Materiel matId) {
        this.matId = matId;
    }

    public Bureau getBureauId() {
        return bureauId;
    }

    public void setBureauId(Bureau bureauId) {
        this.bureauId = bureauId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depId != null ? depId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.depId == null && other.depId != null) || (this.depId != null && !this.depId.equals(other.depId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facec.facecapps.entities.Departement[ depId=" + depId + " ]";
    }
    
}
