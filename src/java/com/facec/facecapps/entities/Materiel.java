/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facec.facecapps.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author facec-cr3
 */
@Entity
@Table(name = "materiel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiel.findAll", query = "SELECT m FROM Materiel m")})
public class Materiel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mat_id")
    private Integer matId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_code")
    private int matCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mat_marque")
    private String matMarque;
    @Size(max = 60)
    @Column(name = "mat_model")
    private String matModel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_dacquis")
    @Temporal(TemporalType.DATE)
    private Date matDacquis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_valacquis")
    private int matValacquis;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private Categorie catId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matId")
    private List<Departement> departementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matId")
    private List<Etat> etatList;

    public Materiel() {
    }

    public Materiel(Integer matId) {
        this.matId = matId;
    }

    public Materiel(Integer matId, int matCode, String matMarque, Date matDacquis, int matValacquis) {
        this.matId = matId;
        this.matCode = matCode;
        this.matMarque = matMarque;
        this.matDacquis = matDacquis;
        this.matValacquis = matValacquis;
    }

    public Integer getMatId() {
        return matId;
    }

    public void setMatId(Integer matId) {
        this.matId = matId;
    }

    public int getMatCode() {
        return matCode;
    }

    public void setMatCode(int matCode) {
        this.matCode = matCode;
    }

    public String getMatMarque() {
        return matMarque;
    }

    public void setMatMarque(String matMarque) {
        this.matMarque = matMarque;
    }

    public String getMatModel() {
        return matModel;
    }

    public void setMatModel(String matModel) {
        this.matModel = matModel;
    }

    public Date getMatDacquis() {
        return matDacquis;
    }

    public void setMatDacquis(Date matDacquis) {
        this.matDacquis = matDacquis;
    }

    public int getMatValacquis() {
        return matValacquis;
    }

    public void setMatValacquis(int matValacquis) {
        this.matValacquis = matValacquis;
    }

    public Categorie getCatId() {
        return catId;
    }

    public void setCatId(Categorie catId) {
        this.catId = catId;
    }

    @XmlTransient
    public List<Departement> getDepartementList() {
        return departementList;
    }

    public void setDepartementList(List<Departement> departementList) {
        this.departementList = departementList;
    }

    @XmlTransient
    public List<Etat> getEtatList() {
        return etatList;
    }

    public void setEtatList(List<Etat> etatList) {
        this.etatList = etatList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matId != null ? matId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiel)) {
            return false;
        }
        Materiel other = (Materiel) object;
        if ((this.matId == null && other.matId != null) || (this.matId != null && !this.matId.equals(other.matId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facec.facecapps.entities.Materiel[ matId=" + matId + " ]";
    }
    
}
