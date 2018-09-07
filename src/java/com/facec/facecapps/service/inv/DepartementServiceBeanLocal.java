package com.facec.facecapps.service.inv;

import javax.ejb.Local;
import com.facec.facecapps.entities.Departement;
import com.facec.facecapps.service.BaseServiceBeanLocal;

/**
 *
 * @author K.M.A
 */
@Local
public interface DepartementServiceBeanLocal extends BaseServiceBeanLocal<Departement, Integer> {
}