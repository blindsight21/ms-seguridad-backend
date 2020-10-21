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
import pe.gob.mimp.ms.seguridad.bean.entidades.EstadoUsuarioBean;
import pe.gob.mimp.ms.seguridad.converter.EstadoUsuarioCast;
import pe.gob.mimp.ms.seguridad.service.EstadoUsuarioService;
import pe.gob.mimp.ms.seguridad.util.Util;
import pe.gob.mimp.seguridad.model.EstadoUsuario;
import pe.gob.mimp.seguridad.repository.estadousuario.EstadoUsuarioRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class EstadoUsuarioServiceImpl implements EstadoUsuarioService {

    @Autowired
    private EstadoUsuarioRepository estadoUsuarioRepository;

    @Override
    public List<EstadoUsuarioBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<EstadoUsuario> estadoUsuarioList = estadoUsuarioRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());

        if(Util.esListaVacia(estadoUsuarioList)){
            return null;
        }
        
        return estadoUsuarioList.stream().map(estadoUsuario -> {
            return EstadoUsuarioCast.castEstadoUsuarioToEstadoUsuarioBean(estadoUsuario);
        }).collect(Collectors.toList());
    }

}
