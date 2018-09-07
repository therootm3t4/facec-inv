package com.facec.facecapps.managedbeans.inv;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.facec.facecapps.entities.Employe;
import com.facec.facecapps.service.inv.EmployeServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "employeManagedBean")
@ViewScoped
public class EmployeManagedBean implements Serializable {

    @EJB
    private EmployeServiceBeanLocal employeService;
    private Employe formEmploye = new Employe();
    private Employe selectedEmploye;
    private List<Employe> dataListEmploye;
    private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;

    /**
     * Creates a new instance of EmployeManagedBean
     */
    public EmployeManagedBean() {
        formEmploye = new Employe();
        selectedEmploye = new Employe();
        dataListEmploye = new ArrayList<Employe>();
    }

    public void enregistrer() {
        try {
            if (selectedEmploye != null) {
                employeService.modifier(formEmploye);
            } else {
                employeService.ajouter(formEmploye);
            }
            effacer();
        } catch (Exception e) {
        }
    }

    public void effacer() {
        formEmploye = new Employe();
        selectedEmploye = null;
    }

    public void supprimer() {
        try {
            if (selectedEmploye != null) {
                employeService.supprimer(selectedEmploye);
            }
            effacer();
        } catch (Exception e) {
        }
    }

    public void rowSelected() {
        formEmploye = selectedEmploye;
        this.desactiverCode = true;
        this.index = this.dataListEmploye.indexOf(this.selectedEmploye);
        this.desactiverBoutonSuppr = false;
    }

    public Employe getFormEmploye() {
        return formEmploye;
    }

    public void setFormEmploye(Employe formEmploye) {
        this.formEmploye = formEmploye;
    }

    public Employe getSelectedEmploye() {
        return selectedEmploye;
    }

    public void setSelectedEmploye(Employe selectedEmploye) {
        this.selectedEmploye = selectedEmploye;
    }

    public List<Employe> getDataListEmploye() {
        dataListEmploye = employeService.selectionnerTout();
        return dataListEmploye;
    }

    public void setDataListEmploye(List<Employe> dataListEmploye) {
        this.dataListEmploye = dataListEmploye;
    }

    public Boolean isDesactiverBoutonSuppr() {
        return desactiverBoutonSuppr;
    }

    public void setDesactiverBoutonSuppr(Boolean desactiverBoutonSuppr) {
        this.desactiverBoutonSuppr = desactiverBoutonSuppr;
    }

    public Boolean isDesactiverCode() {
        return desactiverCode;
    }

    public void setDesactiverCode(Boolean desactiverCode) {
        this.desactiverCode = desactiverCode;
    }
}
