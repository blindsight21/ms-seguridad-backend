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
import pe.gob.mimp.ms.seguridad.bean.UsuarioModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.PerfilUsuarioBean;
import pe.gob.mimp.ms.seguridad.converter.ModuloCast;
import pe.gob.mimp.ms.seguridad.converter.PerfilUsuarioCast;
import pe.gob.mimp.ms.seguridad.converter.UsuarioCast;
import pe.gob.mimp.ms.seguridad.service.PerfilUsuarioService;
import pe.gob.mimp.ms.seguridad.util.Util;
import pe.gob.mimp.seguridad.model.Modulo;
import pe.gob.mimp.seguridad.model.PerfilUsuario;
import pe.gob.mimp.seguridad.model.Usuario;
import pe.gob.mimp.seguridad.repository.perfilusuario.PerfilUsuarioRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class PerfilUsuarioServiceImpl implements PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    @Override
    public void crearPerfilUsuario(PerfilUsuarioBean perfilUsuarioBeanNuevo) throws Exception {

        PerfilUsuario perfilUsuarioNuevo = PerfilUsuarioCast.castPerfilUsuarioBeanToPerfilUsuario(perfilUsuarioBeanNuevo);

        perfilUsuarioRepository.save(perfilUsuarioNuevo);

    }

    @Override
    public List<PerfilUsuarioBean> obtenerPerfilUsuarioPorModulo(UsuarioModuloBean usuarioModuloBean) throws Exception {

        if (usuarioModuloBean == null) {
            return null;
        }

        Usuario usuario = UsuarioCast.castUsuarioBeanToUsuario(usuarioModuloBean.getUsuarioBean());
        Modulo modulo = ModuloCast.castModuloBeanToModulo(usuarioModuloBean.getModuloBean());

        List<PerfilUsuario> perfilUsuarioList = perfilUsuarioRepository.obtenerPerfilUsuarioPorModulo(usuario, modulo);

        if (Util.esListaVacia(perfilUsuarioList)) {
            return null;
        }

        return perfilUsuarioList.stream().map(perfilUsuario -> {
            return PerfilUsuarioCast.castPerfilUsuarioToPerfilUsuarioBean(perfilUsuario);
        }).collect(Collectors.toList());

    }

    @Override
    public void remove(PerfilUsuarioBean perfilUsuarioBeanEliminado) throws Exception {

        PerfilUsuario perfilUsuarioEliminado = PerfilUsuarioCast.castPerfilUsuarioBeanToPerfilUsuario(perfilUsuarioBeanEliminado);

        perfilUsuarioRepository.delete(perfilUsuarioEliminado);

    }

}
