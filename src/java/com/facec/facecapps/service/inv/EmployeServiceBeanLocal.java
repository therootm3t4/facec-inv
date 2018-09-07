package com.facec.facecapps.service.inv;

import javax.ejb.Local;
import com.facec.facecapps.entities.Employe;
import com.facec.facecapps.service.BaseServiceBeanLocal;

/**
 *
 * @author K.M.A
 */
@Local
public interface EmployeServiceBeanLocal extends BaseServiceBeanLocal<Employe, Integer> {
}