/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.ms.seguridad.bean.FindAllByFieldBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.ParametroSeguridadBean;
import pe.gob.mimp.ms.seguridad.converter.ParametroSeguridadCast;
import pe.gob.mimp.ms.seguridad.service.ParametroSeguridadService;
import pe.gob.mimp.ms.seguridad.util.Util;
import pe.gob.mimp.seguridad.model.ParametroSeguridad;
import pe.gob.mimp.seguridad.repository.parametroseguridad.ParamSeguridadRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ParametroSeguridadServiceImpl implements ParametroSeguridadService {

    @Autowired
    private ParamSeguridadRepository parametroSeguridadRepository;

    @Override
    public List<ParametroSeguridadBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<ParametroSeguridad> parametroSeguridadList = parametroSeguridadRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());

        if (Util.esListaVacia(parametroSeguridadList)) {
            return null;
        }

        return parametroSeguridadList.stream().map(parametroSeguridad -> {
            return ParametroSeguridadCast.castParametroSeguridadToParametroSeguridadBean(parametroSeguridad);
        }).collect(Collectors.toList());
    }

}
