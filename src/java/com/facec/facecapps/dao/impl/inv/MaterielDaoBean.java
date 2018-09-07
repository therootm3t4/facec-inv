package com.facec.facecapps.dao.impl.inv;

import com.facec.facecapps.dao.inv.MaterielDaoBeanLocal;
import com.facec.facecapps.dao.impl.BaseDaoBean;
import com.facec.facecapps.entities.Materiel;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class MaterielDaoBean extends BaseDaoBean<Materiel,Integer> implements MaterielDaoBeanLocal {

    public MaterielDaoBean() {
        super(Materiel.class);
    }

    
}
