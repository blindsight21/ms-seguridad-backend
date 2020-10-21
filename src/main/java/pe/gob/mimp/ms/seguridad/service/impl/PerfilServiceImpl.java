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
import pe.gob.mimp.ms.seguridad.bean.UsuarioModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.ModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.PerfilBean;
import pe.gob.mimp.ms.seguridad.converter.ModuloCast;
import pe.gob.mimp.ms.seguridad.converter.PerfilCast;
import pe.gob.mimp.ms.seguridad.converter.UsuarioCast;
import pe.gob.mimp.ms.seguridad.service.PerfilService;
import pe.gob.mimp.ms.seguridad.util.Util;
import pe.gob.mimp.seguridad.model.Modulo;
import pe.gob.mimp.seguridad.model.Perfil;
import pe.gob.mimp.seguridad.model.Usuario;
import pe.gob.mimp.seguridad.repository.perfil.PerfilRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public List<PerfilBean> obtenerPerfiles(UsuarioModuloBean perfilModuloBean) throws Exception {

        Usuario usuario = UsuarioCast.castUsuarioBeanToUsuario(perfilModuloBean.getUsuarioBean());
        Modulo modulo = ModuloCast.castModuloBeanToModulo(perfilModuloBean.getModuloBean());

        List<Perfil> perfilList = perfilRepository.obtenerPerfiles(usuario, modulo);

        if (Util.esListaVacia(perfilList)) {
            return null;
        }

        return perfilList.stream().map(perfil -> {
            return PerfilCast.castPerfilToPerfilBean(perfil);
        }).collect(Collectors.toList());

    }

    @Override
    public PerfilBean find(BigDecimal id) throws Exception {
        if (id == null) {
            return null;
        }

        Optional<Perfil> perfil = perfilRepository.findById(id);

        if (!perfil.isPresent()) {
            return null;
        }

        return PerfilCast.castPerfilToPerfilBean(perfil.get());
    }

    @Override
    public List<PerfilBean> findAll() throws Exception {
        List<Perfil> perfilList = perfilRepository.findAll();

        if (Util.esListaVacia(perfilList)) {
            return null;
        }

        return perfilList.stream().map(perfil -> {
            return PerfilCast.castPerfilToPerfilBean(perfil);
        }).collect(Collectors.toList());
    }

    @Override
    public List<PerfilBean> obtenerPerfilesDelModulo(ModuloBean moduloBean) throws Exception {

        Modulo modulo = ModuloCast.castModuloBeanToModulo(moduloBean);

        List<Perfil> perfilList = perfilRepository.obtenerPerfilesDelModulo(modulo);

        if (Util.esListaVacia(perfilList)) {
            return null;
        }

        return perfilList.stream().map(perfil -> {
            return PerfilCast.castPerfilToPerfilBean(perfil);
        }).collect(Collectors.toList());
    }

}
