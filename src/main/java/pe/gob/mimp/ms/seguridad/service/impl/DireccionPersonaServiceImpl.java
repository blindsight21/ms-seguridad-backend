/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.ms.seguridad.bean.entidades.DireccionPersonaBean;
import pe.gob.mimp.ms.seguridad.converter.DireccionPersonaCast;
import pe.gob.mimp.ms.seguridad.service.DireccionPersonaService;
import pe.gob.mimp.seguridad.model.DireccionPersona;
import pe.gob.mimp.seguridad.repository.direccionpersona.DireccionPersonaRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DireccionPersonaServiceImpl implements DireccionPersonaService {

    @Autowired
    private DireccionPersonaRepository personaRepository;

    @Override
    public void crearDireccionPersona(DireccionPersonaBean direccionPersonaBean) throws Exception {

        DireccionPersona direccionPersonaNuevo = DireccionPersonaCast.castDireccionPersonaBeanToDireccionPersona(direccionPersonaBean);
        personaRepository.save(direccionPersonaNuevo);

    }

}
