package com.facec.facecapps.service.impl.inv;

import com.facec.facecapps.service.impl.BaseServiceBean;
import com.facec.facecapps.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.facec.facecapps.service.inv.MaterielServiceBeanLocal;
import com.facec.facecapps.dao.inv.MaterielDaoBeanLocal;
import com.facec.facecapps.entities.Materiel;
/**
 *
 * @author K.M.A
 */
@Stateless
public class MaterielServiceBean extends BaseServiceBean<Materiel, Integer> implements MaterielServiceBeanLocal {

@EJB
private MaterielDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Materiel, Integer> getDao() {
        return this.dao;
    }
}