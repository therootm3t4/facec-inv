/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facec.facecapps.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import com.facec.facecapps.dao.BaseDaoBeanLocal;
import com.facec.facecapps.service.BaseServiceBeanLocal;

/**
 *
 * @author  K.M.A.
 */
public abstract class BaseServiceBean<T  extends Serializable, K> implements BaseServiceBeanLocal<T, K> {

    
    protected abstract BaseDaoBeanLocal<T, K> getDao();
    
    @Override
    public List<T> selectionnerTout() {
        return this.getDao().selectionnerTout();
    }

    @Override
    public List<T> selectionnerTout(String proprieteTri, boolean triAscendant) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<T> selectionnerTout(int debut, int total) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<T> selectionnerTout(int debut, int total, String proprieteTri, boolean triAscendant) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T selectionner(K k) {
        return this.getDao().selectionner(k);
    }

    @Override
    public void ajouter(T t) {
        this.getDao().ajouter(t);
    }

    @Override
    public void ajouter(Collection<T> ts) {
        for (T t : ts) {
            this.getDao().ajouter(t);
        }
    }

    @Override
    public void modifier(T t) {
        this.getDao().modifier(t);
    }

    @Override
    public void supprimer(K k) {
        this.getDao().supprimer(this.getDao().selectionner(k));
    }

    @Override
    public void supprimer(T t) {
        this.getDao().supprimer(t);
    }

    @Override
    public void supprimer(Collection<T> ts) {
        for (T t: ts) {
            this.getDao().supprimer(t);
        }
    }

    @Override
    public void supprimerTout() {
        this.getDao().supprimerTout();
    }

    @Override
    public int compter() {
        return this.getDao().compter();
    }

    @Override
    public T selectionner(String propriete, String valeur) {
        return this.getDao().selectionner(propriete, valeur);
    }

 

    
}
