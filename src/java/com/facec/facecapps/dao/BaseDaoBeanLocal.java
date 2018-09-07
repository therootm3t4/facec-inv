package com.facec.facecapps.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author  K.M.A.
 */
@Local
public interface BaseDaoBeanLocal<T extends Serializable, K> {
  
    List<T>  selectionnerTout();
    
    T selectionner(K k);
    
    void ajouter(final T t);
    
    void modifier(final T t);
    
    void supprimer(final K k);
    
    void supprimer(final T t);
    
    void supprimerTout();
    
    int compter();
    
    void ajouter(final Collection<T> ts);
    
    T selectionner(String propriete,String valeur);
    
    
}
