package com.facec.facecapps.managedbeans.inv;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.facec.facecapps.entities.Etat;
import com.facec.facecapps.service.inv.EtatServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "etatManagedBean")
@ViewScoped
public class EtatManagedBean  implements Serializable{

    @EJB
    private EtatServiceBeanLocal etatService;
    private Etat formEtat = new Etat();
    private Etat selectedEtat;
    private List<Etat> dataListEtat;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of EtatManagedBean
     */
    public EtatManagedBean() {
     formEtat = new Etat();
     selectedEtat = new Etat();
     dataListEtat = new ArrayList<Etat>();
    }
    
    public void enregistrer(){
       try{
        if(selectedEtat != null){
            etatService.modifier(formEtat);
        }else{
            etatService.ajouter(formEtat);
        }
        effacer();
      }catch(Exception e){
      }
    }
    
    public void effacer(){
        formEtat = new Etat();
        selectedEtat = null;
    }
    
    public void supprimer(){
      try{
        if(selectedEtat != null){
            etatService.supprimer(selectedEtat.getEtatId());
        }
        effacer();
      }catch(Exception e){
      }
    }

 public void rowSelected() {
        formEtat = selectedEtat;
        this.desactiverCode = true;
        this.index = this.dataListEtat.indexOf(this.selectedEtat);
        this.desactiverBoutonSuppr = false;
    }

    public Etat getFormEtat() {
        return formEtat;
    }

    public void setFormEtat(Etat formEtat) {
        this.formEtat = formEtat;
    }

    public Etat getSelectedEtat() {
        return selectedEtat;
    }

    public void setSelectedEtat(Etat selectedEtat) {
        this.selectedEtat = selectedEtat;
    }

    public List<Etat> getDataListEtat() {
        dataListEtat = etatService.selectionnerTout();
        return dataListEtat;
    }

    public void setDataListEtat(List<Etat> dataListEtat) {
        this.dataListEtat = dataListEtat;
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
