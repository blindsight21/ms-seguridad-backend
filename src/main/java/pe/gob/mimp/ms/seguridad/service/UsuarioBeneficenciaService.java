/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service;

import java.util.List;
import pe.gob.mimp.ms.seguridad.bean.FindByParamBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.UsuarioBeneficenciaBean;

/**
 *
 * @author Omar
 */
public interface UsuarioBeneficenciaService {

    List<UsuarioBeneficenciaBean> findByParams(FindByParamBean findByParamBean) throws Exception;
}
