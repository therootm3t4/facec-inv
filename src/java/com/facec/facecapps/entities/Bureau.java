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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bureau")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bureau.findAll", query = "SELECT b FROM Bureau b")})
public class Bureau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bureau_id")
    private Integer bureauId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "bureau_ref")
    private String bureauRef;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bureauId")
    private List<Departement> departementList;
    @JoinColumn(name = "employe_id", referencedColumnName = "employe_id")
    @ManyToOne(optional = false)
    private Employe employeId;

    public Bureau() {
    }

    public Bureau(Integer bureauId) {
        this.bureauId = bureauId;
    }

    public Bureau(Integer bureauId, String bureauRef) {
        this.bureauId = bureauId;
        this.bureauRef = bureauRef;
    }

    public Integer getBureauId() {
        return bureauId;
    }

    public void setBureauId(Integer bureauId) {
        this.bureauId = bureauId;
    }

    public String getBureauRef() {
        return bureauRef;
    }

    public void setBureauRef(String bureauRef) {
        this.bureauRef = bureauRef;
    }

    @XmlTransient
    public List<Departement> getDepartementList() {
        return departementList;
    }

    public void setDepartementList(List<Departement> departementList) {
        this.departementList = departementList;
    }

    public Employe getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Employe employeId) {
        this.employeId = employeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bureauId != null ? bureauId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bureau)) {
            return false;
        }
        Bureau other = (Bureau) object;
        if ((this.bureauId == null && other.bureauId != null) || (this.bureauId != null && !this.bureauId.equals(other.bureauId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facec.facecapps.entities.Bureau[ bureauId=" + bureauId + " ]";
    }
    
}
