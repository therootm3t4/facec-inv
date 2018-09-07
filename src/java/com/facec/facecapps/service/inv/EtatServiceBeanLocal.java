package com.facec.facecapps.service.inv;

import javax.ejb.Local;
import com.facec.facecapps.entities.Etat;
import com.facec.facecapps.service.BaseServiceBeanLocal;

/**
 *
 * @author K.M.A
 */
@Local
public interface EtatServiceBeanLocal extends BaseServiceBeanLocal<Etat, Integer> {
}