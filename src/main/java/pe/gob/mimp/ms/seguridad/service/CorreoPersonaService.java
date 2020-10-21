/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service;

import pe.gob.mimp.ms.seguridad.bean.entidades.CorreoPersonaBean;

/**
 *
 * @author Omar
 */
public interface CorreoPersonaService {

    void crearCorreoPersona(CorreoPersonaBean correoPersonaBeanNuevo) throws Exception;

}
