package com.facec.facecapps.service.inv;

import javax.ejb.Local;
import com.facec.facecapps.entities.Categorie;
import com.facec.facecapps.service.BaseServiceBeanLocal;

/**
 *
 * @author K.M.A
 */
@Local
public interface CategorieServiceBeanLocal extends BaseServiceBeanLocal<Categorie, Integer> {
}