/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.ms.seguridad.bean.FindAllByFieldBean;
import pe.gob.mimp.ms.seguridad.bean.UsuarioModuloBean;
import pe.gob.mimp.ms.seguridad.bean.ValidarBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.FuncionalidadBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.ModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.UsuarioBean;
import pe.gob.mimp.ms.seguridad.converter.FuncionalidadCast;
import pe.gob.mimp.ms.seguridad.converter.ModuloCast;
import pe.gob.mimp.ms.seguridad.converter.UsuarioCast;
import pe.gob.mimp.ms.seguridad.service.UsuarioService;
import pe.gob.mimp.ms.seguridad.util.Util;
import pe.gob.mimp.seguridad.model.Funcionalidad;
import pe.gob.mimp.seguridad.model.Modulo;
import pe.gob.mimp.seguridad.model.Usuario;
import pe.gob.mimp.seguridad.repository.usuario.UsuarioRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void crearUsuario(UsuarioBean usuarioBeanNuevo) throws Exception {

        Usuario usuarioNuevo = UsuarioCast.castUsuarioBeanToUsuario(usuarioBeanNuevo);

        usuarioRepository.save(usuarioNuevo);

    }

    @Override
    public void editarUsuario(UsuarioBean usuarioBeanEditado) {

        if (usuarioBeanEditado.getNidUsuario() == null) {
            return;
        }

        Usuario usuarioEditado = UsuarioCast.castUsuarioBeanToUsuario(usuarioBeanEditado);

        usuarioRepository.save(usuarioEditado);

    }

    @Override
    public List<UsuarioBean> findAll() throws Exception {

        List<Usuario> usuarioList = usuarioRepository.findAll();

        if (Util.esListaVacia(usuarioList)) {
            return null;
        }

        return usuarioList.stream().map(usuario -> {
            return UsuarioCast.castUsuarioToUsuarioBean(usuario);
        }).collect(Collectors.toList());
    }

    @Override
    public UsuarioBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (!usuario.isPresent()) {
            return null;
        }

        return UsuarioCast.castUsuarioToUsuarioBean(usuario.get());
    }

    @Override
    public List<UsuarioBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<Usuario> usuarioList = usuarioRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());

        if (Util.esListaVacia(usuarioList)) {
            return null;
        }

        return usuarioList.stream().map(usuario -> {
            return UsuarioCast.castUsuarioToUsuarioBean(usuario);
        }).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioBean> getEntidadesModulo(ModuloBean moduloBean) throws Exception {

        Modulo modulo = ModuloCast.castModuloBeanToModulo(moduloBean);

        List<Usuario> usuarioList = usuarioRepository.getEntidadesModulo(modulo);

        if (Util.esListaVacia(usuarioList)) {
            return null;
        }

        return usuarioList.stream().map(usuario -> {
            return UsuarioCast.castUsuarioToUsuarioBean(usuario);
        }).collect(Collectors.toList());

    }

    @Override
    public List<UsuarioBean> validar(ValidarBean validarBean) throws Exception {

        if (validarBean == null) {
            return null;
        }
        
        Modulo modulo = ModuloCast.castModuloBeanToModulo(validarBean.getModuloBean());

        List<Usuario> usuarioList = usuarioRepository.validar(validarBean.getUsuario(), validarBean.getPassword(), modulo);

        if (Util.esListaVacia(usuarioList)) {
            return null;
        }

        return usuarioList.stream().map(usuario -> {
            return UsuarioCast.castUsuarioToUsuarioBean(usuario);
        }).collect(Collectors.toList());

    }

    @Override
    public List<FuncionalidadBean> obtenerFuncionalidades(UsuarioModuloBean usuarioModuloBean) throws Exception {

        Usuario usuario = UsuarioCast.castUsuarioBeanToUsuario(usuarioModuloBean.getUsuarioBean());
        Modulo modulo = ModuloCast.castModuloBeanToModulo(usuarioModuloBean.getModuloBean());

        List<Funcionalidad> funcionalidadList = usuarioRepository.obtenerFuncionalidades(usuario, modulo);

        if (Util.esListaVacia(funcionalidadList)) {
            return null;
        }

        return funcionalidadList.stream().map(funcionalidad -> {
            return FuncionalidadCast.castFuncionalidadToFuncionalidadBean(funcionalidad);
        }).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioBean> getEntidadesModuloTodos(ModuloBean moduloBean) throws Exception {

        Modulo modulo = ModuloCast.castModuloBeanToModulo(moduloBean);

        List<Usuario> usuarioList = usuarioRepository.getEntidadesModuloTodos(modulo);

        if (Util.esListaVacia(usuarioList)) {
            return null;
        }

        return usuarioList.stream().map(usuario -> {
            return UsuarioCast.castUsuarioToUsuarioBean(usuario);
        }).collect(Collectors.toList());

    }
}
