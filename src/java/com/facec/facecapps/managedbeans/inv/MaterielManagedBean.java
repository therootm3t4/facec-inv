package com.facec.facecapps.managedbeans.inv;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.facec.facecapps.entities.Materiel;
import com.facec.facecapps.service.inv.MaterielServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "materielManagedBean")
@ViewScoped
public class MaterielManagedBean  implements Serializable{

    @EJB
    private MaterielServiceBeanLocal materielService;
    private Materiel formMateriel = new Materiel();
    private Materiel selectedMateriel;
    private List<Materiel> dataListMateriel;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of MaterielManagedBean
     */
    public MaterielManagedBean() {
     formMateriel = new Materiel();
     selectedMateriel = new Materiel();
     dataListMateriel = new ArrayList<Materiel>();
    }
    
    public void enregistrer(){
       try{
        if(selectedMateriel != null){
            materielService.modifier(formMateriel);
        }else{
            materielService.ajouter(formMateriel);
        }
        effacer();
      }catch(Exception e){
      }
    }
    
    public void effacer(){
        formMateriel = new Materiel();
        selectedMateriel = null;
    }
    
    public void supprimer(){
      try{
        if(selectedMateriel != null){
            materielService.supprimer(selectedMateriel);
        }
        effacer();
      }catch(Exception e){
      }
    }

 public void rowSelected() {
        formMateriel = selectedMateriel;
        this.desactiverCode = true;
        this.index = this.dataListMateriel.indexOf(this.selectedMateriel);
        this.desactiverBoutonSuppr = false;
    }

    public Materiel getFormMateriel() {
        return formMateriel;
    }

    public void setFormMateriel(Materiel formMateriel) {
        this.formMateriel = formMateriel;
    }

    public Materiel getSelectedMateriel() {
        return selectedMateriel;
    }

    public void setSelectedMateriel(Materiel selectedMateriel) {
        this.selectedMateriel = selectedMateriel;
    }

    public List<Materiel> getDataListMateriel() {
        dataListMateriel=materielService.selectionnerTout();
        return dataListMateriel;
    }

    public void setDataListMateriel(List<Materiel> dataListMateriel) {
        this.dataListMateriel = dataListMateriel;
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
