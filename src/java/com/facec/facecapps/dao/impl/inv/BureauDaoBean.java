package com.facec.facecapps.dao.impl.inv;

import com.facec.facecapps.dao.inv.BureauDaoBeanLocal;
import com.facec.facecapps.dao.impl.BaseDaoBean;
import com.facec.facecapps.entities.Bureau;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class BureauDaoBean extends BaseDaoBean<Bureau,Integer> implements BureauDaoBeanLocal {

    public BureauDaoBean() {
        super(Bureau.class);
    }

    
}
