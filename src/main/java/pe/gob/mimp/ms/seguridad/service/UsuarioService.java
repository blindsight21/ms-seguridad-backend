/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.ms.seguridad.bean.FindAllByFieldBean;
import pe.gob.mimp.ms.seguridad.bean.UsuarioModuloBean;
import pe.gob.mimp.ms.seguridad.bean.ValidarBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.FuncionalidadBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.ModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.UsuarioBean;

/**
 *
 * @author Omar
 */
public interface UsuarioService {

    void crearUsuario(UsuarioBean usuario) throws Exception;

    void editarUsuario(UsuarioBean usuario) throws Exception;

    List<UsuarioBean> findAll() throws Exception;

    UsuarioBean find(BigDecimal id) throws Exception;

    List<UsuarioBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception;

    List<UsuarioBean> getEntidadesModulo(ModuloBean modulo) throws Exception;

    List<UsuarioBean> validar(ValidarBean validarBean) throws Exception;

    List<FuncionalidadBean> obtenerFuncionalidades(UsuarioModuloBean usuarioModuloBean) throws Exception;

    List<UsuarioBean> getEntidadesModuloTodos(ModuloBean modulo) throws Exception;
}
