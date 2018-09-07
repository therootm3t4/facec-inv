package com.facec.facecapps.service.impl.inv;

import com.facec.facecapps.service.impl.BaseServiceBean;
import com.facec.facecapps.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.facec.facecapps.service.inv.EtatServiceBeanLocal;
import com.facec.facecapps.dao.inv.EtatDaoBeanLocal;
import com.facec.facecapps.entities.Etat;
/**
 *
 * @author K.M.A
 */
@Stateless
public class EtatServiceBean extends BaseServiceBean<Etat, Integer> implements EtatServiceBeanLocal {

@EJB
private EtatDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Etat, Integer> getDao() {
        return this.dao;
    }
}