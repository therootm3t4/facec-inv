package com.facec.facecapps.service.impl.inv;

import com.facec.facecapps.service.impl.BaseServiceBean;
import com.facec.facecapps.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.facec.facecapps.service.inv.DepartementServiceBeanLocal;
import com.facec.facecapps.dao.inv.DepartementDaoBeanLocal;
import com.facec.facecapps.entities.Departement;
/**
 *
 * @author K.M.A
 */
@Stateless
public class DepartementServiceBean extends BaseServiceBean<Departement, Integer> implements DepartementServiceBeanLocal {

@EJB
private DepartementDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Departement, Integer> getDao() {
        return this.dao;
    }
}