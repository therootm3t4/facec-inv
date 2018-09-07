package com.facec.facecapps.service.impl.inv;

import com.facec.facecapps.service.impl.BaseServiceBean;
import com.facec.facecapps.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.facec.facecapps.service.inv.EmployeServiceBeanLocal;
import com.facec.facecapps.dao.inv.EmployeDaoBeanLocal;
import com.facec.facecapps.entities.Employe;
/**
 *
 * @author K.M.A
 */
@Stateless
public class EmployeServiceBean extends BaseServiceBean<Employe, Integer> implements EmployeServiceBeanLocal {

@EJB
private EmployeDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Employe, Integer> getDao() {
        return this.dao;
    }
}