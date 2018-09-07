package com.facec.facecapps.service.impl.inv;

import com.facec.facecapps.service.impl.BaseServiceBean;
import com.facec.facecapps.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.facec.facecapps.service.inv.CategorieServiceBeanLocal;
import com.facec.facecapps.dao.inv.CategorieDaoBeanLocal;
import com.facec.facecapps.entities.Categorie;
/**
 *
 * @author K.M.A
 */
@Stateless
public class CategorieServiceBean extends BaseServiceBean<Categorie, Integer> implements CategorieServiceBeanLocal {

@EJB
private CategorieDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Categorie, Integer> getDao() {
        return this.dao;
    }
}