package com.facec.facecapps.managedbeans.inv;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.facec.facecapps.entities.Bureau;
import com.facec.facecapps.service.inv.BureauServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "bureauManagedBean")
@ViewScoped
public class BureauManagedBean  implements Serializable{

    @EJB
    private BureauServiceBeanLocal bureauService;
    private Bureau formBureau = new Bureau();
    private Bureau selectedBureau;
    private List<Bureau> dataListBureau;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of BureauManagedBean
     */
    public BureauManagedBean() {
     formBureau = new Bureau();
     selectedBureau = new Bureau();
     dataListBureau = new ArrayList<Bureau>();
    }
    
    public void enregistrer(){
       try{
        if(selectedBureau != null){
            bureauService.modifier(formBureau);
        }else{
            bureauService.ajouter(formBureau);
        }
        effacer();
      }catch(Exception e){
      }
    }
    
    public void effacer(){
        formBureau = new Bureau();
        selectedBureau = null;
    }
    
    public void supprimer(){
      try{
        if(selectedBureau != null){
            bureauService.supprimer(selectedBureau.getBureauId());
        }
        effacer();
      }catch(Exception e){
      }
    }

 public void rowSelected() {
        formBureau = selectedBureau;
        this.desactiverCode = true;
        this.index = this.dataListBureau.indexOf(this.selectedBureau);
        this.desactiverBoutonSuppr = false;
    }

    public Bureau getFormBureau() {
        return formBureau;
    }

    public void setFormBureau(Bureau formBureau) {
        this.formBureau = formBureau;
    }

    public Bureau getSelectedBureau() {
        return selectedBureau;
    }

    public void setSelectedBureau(Bureau selectedBureau) {
        this.selectedBureau = selectedBureau;
    }

    public List<Bureau> getDataListBureau() {
       dataListBureau = bureauService.selectionnerTout();
        return dataListBureau;
    }

    public void setDataListBureau(List<Bureau> dataListBureau) {
        this.dataListBureau = dataListBureau;
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
