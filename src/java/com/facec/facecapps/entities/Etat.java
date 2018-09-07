/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facec.facecapps.entities;

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
 * @author facec-cr3
 */
@Entity
@Table(name = "etat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etat.findAll", query = "SELECT e FROM Etat e")})
public class Etat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "etat_id")
    private Integer etatId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "etat_statut")
    private String etatStatut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat_date")
    @Temporal(TemporalType.DATE)
    private Date etatDate;
    @JoinColumn(name = "mat_id", referencedColumnName = "mat_id")
    @ManyToOne(optional = false)
    private Materiel matId;

    public Etat() {
    }

    public Etat(Integer etatId) {
        this.etatId = etatId;
    }

    public Etat(Integer etatId, String etatStatut, Date etatDate) {
        this.etatId = etatId;
        this.etatStatut = etatStatut;
        this.etatDate = etatDate;
    }

    public Integer getEtatId() {
        return etatId;
    }

    public void setEtatId(Integer etatId) {
        this.etatId = etatId;
    }

    public String getEtatStatut() {
        return etatStatut;
    }

    public void setEtatStatut(String etatStatut) {
        this.etatStatut = etatStatut;
    }

    public Date getEtatDate() {
        return etatDate;
    }

    public void setEtatDate(Date etatDate) {
        this.etatDate = etatDate;
    }

    public Materiel getMatId() {
        return matId;
    }

    public void setMatId(Materiel matId) {
        this.matId = matId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etatId != null ? etatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etat)) {
            return false;
        }
        Etat other = (Etat) object;
        if ((this.etatId == null && other.etatId != null) || (this.etatId != null && !this.etatId.equals(other.etatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facec.facecapps.entities.Etat[ etatId=" + etatId + " ]";
    }
    
}
