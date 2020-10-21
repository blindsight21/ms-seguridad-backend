/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service;

import java.util.List;
import pe.gob.mimp.ms.seguridad.bean.FindAllByFieldBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.TipoPersonaBean;

/**
 *
 * @author Omar
 */
public interface TipoPersonaService {

    List<TipoPersonaBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception;

}
