/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.ms.seguridad.bean.entidades.CorreoPersonaBean;
import pe.gob.mimp.ms.seguridad.converter.CorreoPersonaCast;
import pe.gob.mimp.ms.seguridad.service.CorreoPersonaService;
import pe.gob.mimp.seguridad.model.CorreoPersona;
import pe.gob.mimp.seguridad.repository.correopersona.CorreoPersonaRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class CorreoPersonaServiceImpl implements CorreoPersonaService {

    @Autowired
    private CorreoPersonaRepository correoPersonaRepository;

    @Override
    public void crearCorreoPersona(CorreoPersonaBean correoPersonaBeanNuevo) throws Exception {

        CorreoPersona correoPersonaNuevo = CorreoPersonaCast.castCorreoPersonaBeanToCorreoPersona(correoPersonaBeanNuevo);

        correoPersonaRepository.save(correoPersonaNuevo);

    }

}
