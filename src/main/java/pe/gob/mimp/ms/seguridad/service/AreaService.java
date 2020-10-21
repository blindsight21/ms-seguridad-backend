/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.ms.seguridad.bean.FindAllByFieldBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.AreaBean;

/**
 *
 * @author Omar
 */
public interface AreaService {

    List<AreaBean> findAll() throws Exception;
    
    AreaBean find(BigDecimal id) throws Exception;

    List<AreaBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception;

}
