package com.facec.facecapps.service.impl.inv;

import com.facec.facecapps.service.impl.BaseServiceBean;
import com.facec.facecapps.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.facec.facecapps.service.inv.BureauServiceBeanLocal;
import com.facec.facecapps.dao.inv.BureauDaoBeanLocal;
import com.facec.facecapps.entities.Bureau;
/**
 *
 * @author K.M.A
 */
@Stateless
public class BureauServiceBean extends BaseServiceBean<Bureau, Integer> implements BureauServiceBeanLocal {

@EJB
private BureauDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Bureau, Integer> getDao() {
        return this.dao;
    }
}