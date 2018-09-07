package com.facec.facecapps.managedbeans.inv;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.facec.facecapps.entities.Departement;
import com.facec.facecapps.service.inv.DepartementServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "departementManagedBean")
@ViewScoped
public class DepartementManagedBean  implements Serializable{

    @EJB
    private DepartementServiceBeanLocal departementService;
    private Departement formDepartement = new Departement();
    private Departement selectedDepartement;
    private List<Departement> dataListDepartement;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of DepartementManagedBean
     */
    public DepartementManagedBean() {
     formDepartement = new Departement();
     selectedDepartement = new Departement();
     dataListDepartement = new ArrayList<Departement>();
    }
    
    public void enregistrer(){
       try{
        if(selectedDepartement != null){
            departementService.modifier(formDepartement);
        }else{
            departementService.ajouter(formDepartement);
        }
        effacer();
      }catch(Exception e){
      }
    }
    
    public void effacer(){
        formDepartement = new Departement();
        selectedDepartement = null;
    }
    
    public void supprimer(){
      try{
        if(selectedDepartement != null){
            departementService.supprimer(selectedDepartement);
        }
        effacer();
      }catch(Exception e){
      }
    }

 public void rowSelected() {
        formDepartement = selectedDepartement;
        this.desactiverCode = true;
        this.index = this.dataListDepartement.indexOf(this.selectedDepartement);
        this.desactiverBoutonSuppr = false;
    }

    public Departement getFormDepartement() {
        return formDepartement;
    }

    public void setFormDepartement(Departement formDepartement) {
        this.formDepartement = formDepartement;
    }

    public Departement getSelectedDepartement() {
        return selectedDepartement;
    }

    public void setSelectedDepartement(Departement selectedDepartement) {
        this.selectedDepartement = selectedDepartement;
    }

    public List<Departement> getDataListDepartement() {
        dataListDepartement = departementService.selectionnerTout();
        return dataListDepartement;
    }

    public void setDataListDepartement(List<Departement> dataListDepartement) {
        this.dataListDepartement = dataListDepartement;
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
