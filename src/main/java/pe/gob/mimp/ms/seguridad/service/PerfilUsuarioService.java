/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service;

import java.util.List;
import pe.gob.mimp.ms.seguridad.bean.UsuarioModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.PerfilUsuarioBean;

/**
 *
 * @author Omar
 */
public interface PerfilUsuarioService {

    void crearPerfilUsuario(PerfilUsuarioBean perfilUsuarioBeanNuevo) throws Exception;

    List<PerfilUsuarioBean> obtenerPerfilUsuarioPorModulo(UsuarioModuloBean usuarioModuloBean) throws Exception;

    void remove(PerfilUsuarioBean perfilUsuarioBeanEliminado) throws Exception;

}
