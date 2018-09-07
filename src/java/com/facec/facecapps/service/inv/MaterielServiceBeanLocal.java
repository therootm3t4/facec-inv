package com.facec.facecapps.service.inv;

import javax.ejb.Local;
import com.facec.facecapps.entities.Materiel;
import com.facec.facecapps.service.BaseServiceBeanLocal;

/**
 *
 * @author K.M.A
 */
@Local
public interface MaterielServiceBeanLocal extends BaseServiceBeanLocal<Materiel, Integer> {
}