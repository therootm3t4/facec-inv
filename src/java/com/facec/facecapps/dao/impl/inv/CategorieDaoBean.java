package com.facec.facecapps.dao.impl.inv;

import com.facec.facecapps.dao.inv.CategorieDaoBeanLocal;
import com.facec.facecapps.dao.impl.BaseDaoBean;
import com.facec.facecapps.entities.Categorie;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class CategorieDaoBean extends BaseDaoBean<Categorie,Integer> implements CategorieDaoBeanLocal {

    public CategorieDaoBean() {
        super(Categorie.class);
    }

    
}
