/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facec.facecapps.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author facec-cr3
 */
@Entity
@Table(name = "employe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e")})
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employe_id")
    private Integer employeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employe_matricule")
    private int employeMatricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "employe_nom_prenom")
    private String employeNomPrenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "employe_sexe")
    private String employeSexe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "employe_statut")
    private String employeStatut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeId")
    private List<Bureau> bureauList;

    public Employe() {
    }

    public Employe(Integer employeId) {
        this.employeId = employeId;
    }

    public Employe(Integer employeId, int employeMatricule, String employeNomPrenom, String employeSexe, String employeStatut) {
        this.employeId = employeId;
        this.employeMatricule = employeMatricule;
        this.employeNomPrenom = employeNomPrenom;
        this.employeSexe = employeSexe;
        this.employeStatut = employeStatut;
    }

    public Integer getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Integer employeId) {
        this.employeId = employeId;
    }

    public int getEmployeMatricule() {
        return employeMatricule;
    }

    public void setEmployeMatricule(int employeMatricule) {
        this.employeMatricule = employeMatricule;
    }

    public String getEmployeNomPrenom() {
        return employeNomPrenom;
    }

    public void setEmployeNomPrenom(String employeNomPrenom) {
        this.employeNomPrenom = employeNomPrenom;
    }

    public String getEmployeSexe() {
        return employeSexe;
    }

    public void setEmployeSexe(String employeSexe) {
        this.employeSexe = employeSexe;
    }

    public String getEmployeStatut() {
        return employeStatut;
    }

    public void setEmployeStatut(String employeStatut) {
        this.employeStatut = employeStatut;
    }

    @XmlTransient
    public List<Bureau> getBureauList() {
        return bureauList;
    }

    public void setBureauList(List<Bureau> bureauList) {
        this.bureauList = bureauList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeId != null ? employeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.employeId == null && other.employeId != null) || (this.employeId != null && !this.employeId.equals(other.employeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facec.facecapps.entities.Employe[ employeId=" + employeId + " ]";
    }
    
}
