/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.ms.seguridad.bean.entidades.PersonaBean;
import pe.gob.mimp.ms.seguridad.converter.PersonaCast;
import pe.gob.mimp.ms.seguridad.service.PersonaService;
import pe.gob.mimp.seguridad.model.Persona;
import pe.gob.mimp.seguridad.repository.persona.PersonaRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public void crearPersona(PersonaBean personaBeanNuevo) throws Exception {

        Persona persona = PersonaCast.castPersonaBeanToPersona(personaBeanNuevo);

        personaRepository.save(persona);

    }

}
