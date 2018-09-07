package com.facec.facecapps.dao.impl.inv;

import com.facec.facecapps.dao.inv.DepartementDaoBeanLocal;
import com.facec.facecapps.dao.impl.BaseDaoBean;
import com.facec.facecapps.entities.Departement;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class DepartementDaoBean extends BaseDaoBean<Departement,Integer> implements DepartementDaoBeanLocal {

    public DepartementDaoBean() {
        super(Departement.class);
    }

    
}
