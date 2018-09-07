package com.facec.facecapps.dao.impl.inv;

import com.facec.facecapps.dao.inv.EtatDaoBeanLocal;
import com.facec.facecapps.dao.impl.BaseDaoBean;
import com.facec.facecapps.entities.Etat;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class EtatDaoBean extends BaseDaoBean<Etat,Integer> implements EtatDaoBeanLocal {

    public EtatDaoBean() {
        super(Etat.class);
    }

    
}
