/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.ms.seguridad.bean.entidades.TelefonoPersonaBean;
import pe.gob.mimp.ms.seguridad.converter.TelefonoPersonaCast;
import pe.gob.mimp.ms.seguridad.service.TelefonoPersonaService;
import pe.gob.mimp.seguridad.model.TelefonoPersona;
import pe.gob.mimp.seguridad.repository.telefonopersona.TelefPersonaRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class TelefonoPersonaServiceImpl implements TelefonoPersonaService {

    @Autowired
    private TelefPersonaRepository telefonoPersonaRepository;

    @Override
    public void crearTelefonoPersona(TelefonoPersonaBean telefonoPersonaNuevoBean) throws Exception {

        TelefonoPersona telefonoPersonaNuevo = TelefonoPersonaCast.castTelefonoPersonaBeanToTelefonoPersona(telefonoPersonaNuevoBean);
        
        telefonoPersonaRepository.save(telefonoPersonaNuevo);

    }

}
