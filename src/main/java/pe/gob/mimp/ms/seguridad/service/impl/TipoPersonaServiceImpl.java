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
import pe.gob.mimp.ms.seguridad.bean.entidades.TipoPersonaBean;
import pe.gob.mimp.ms.seguridad.converter.TipoPersonaCast;
import pe.gob.mimp.ms.seguridad.service.TipoPersonaService;
import pe.gob.mimp.ms.seguridad.util.Util;
import pe.gob.mimp.seguridad.model.TipoPersona;
import pe.gob.mimp.seguridad.repository.tipopersona.TipoPersonaRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class TipoPersonaServiceImpl implements TipoPersonaService {

    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    @Override
    public List<TipoPersonaBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<TipoPersona> tipoPersonaList = tipoPersonaRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());

        if (Util.esListaVacia(tipoPersonaList)) {
            return null;
        }

        return tipoPersonaList.stream().map(tipoPersona -> {
            return TipoPersonaCast.castTipoPersonaToTipoPersonaBean(tipoPersona);
        }).collect(Collectors.toList());
    }

}
