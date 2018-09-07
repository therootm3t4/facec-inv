package com.facec.facecapps.managedbeans.inv;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.facec.facecapps.entities.Categorie;
import com.facec.facecapps.service.inv.CategorieServiceBeanLocal;
import java.util.ArrayList;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "categorieManagedBean")
@ViewScoped
public class CategorieManagedBean implements Serializable {

    @EJB
    private CategorieServiceBeanLocal categorieService;
    private Categorie formCategorie = new Categorie();
    private Categorie selectedCategorie;
    private List<Categorie> dataListCategorie;
    private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;

    /**
     * Creates a new instance of CategorieManagedBean
     */
    public CategorieManagedBean() {
        formCategorie = new Categorie();
        selectedCategorie = new Categorie();
        dataListCategorie = new ArrayList<Categorie>();
    }

    public void enregistrer() {
        try {
            if (selectedCategorie != null) {
                categorieService.modifier(formCategorie);
            } else {
                categorieService.ajouter(formCategorie);
            }
            effacer();
        } catch (Exception e) {
        }
    }

    public void effacer() {
        formCategorie = new Categorie();
        selectedCategorie = null;
    }

    public void supprimer() {
        try {
            if (selectedCategorie != null) {
                categorieService.supprimer(selectedCategorie);
            }
            effacer();
        } catch (Exception e) {
        }
    }

    public void rowSelected() {
        formCategorie = selectedCategorie;
        this.desactiverCode = true;
        this.index = this.dataListCategorie.indexOf(this.selectedCategorie);
        this.desactiverBoutonSuppr = false;
    }

    public Categorie getFormCategorie() {
        return formCategorie;
    }

    public void setFormCategorie(Categorie formCategorie) {
        this.formCategorie = formCategorie;
    }

    public Categorie getSelectedCategorie() {
        return selectedCategorie;
    }

    public void setSelectedCategorie(Categorie selectedCategorie) {
        this.selectedCategorie = selectedCategorie;
    }

    public List<Categorie> getDataListCategorie() {
        dataListCategorie = categorieService.selectionnerTout();
        return dataListCategorie;
    }

    public void setDataListCategorie(List<Categorie> dataListCategorie) {
        this.dataListCategorie = dataListCategorie;
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
