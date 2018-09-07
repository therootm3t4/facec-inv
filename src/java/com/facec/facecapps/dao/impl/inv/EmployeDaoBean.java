package com.facec.facecapps.dao.impl.inv;

import com.facec.facecapps.dao.inv.EmployeDaoBeanLocal;
import com.facec.facecapps.dao.impl.BaseDaoBean;
import com.facec.facecapps.entities.Employe;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class EmployeDaoBean extends BaseDaoBean<Employe,Integer> implements EmployeDaoBeanLocal {

    public EmployeDaoBean() {
        super(Employe.class);
    }

    
}
