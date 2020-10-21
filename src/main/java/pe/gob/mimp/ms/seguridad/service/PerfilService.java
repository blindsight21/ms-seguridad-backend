/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.ms.seguridad.bean.UsuarioModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.ModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.PerfilBean;

/**
 *
 * @author Omar
 */
public interface PerfilService {

    List<PerfilBean> obtenerPerfiles(UsuarioModuloBean usuarioModuloBean) throws Exception;

    PerfilBean find(BigDecimal id) throws Exception;

    List<PerfilBean> findAll() throws Exception;

    List<PerfilBean> obtenerPerfilesDelModulo(ModuloBean modulo) throws Exception;

}
