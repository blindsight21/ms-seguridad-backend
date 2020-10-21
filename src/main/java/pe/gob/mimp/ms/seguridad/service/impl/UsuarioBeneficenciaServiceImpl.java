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
import pe.gob.mimp.ms.seguridad.bean.FindByParamBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.UsuarioBeneficenciaBean;
import pe.gob.mimp.ms.seguridad.converter.UsuarioBeneficenciaCast;
import pe.gob.mimp.ms.seguridad.service.UsuarioBeneficenciaService;
import pe.gob.mimp.ms.seguridad.util.Util;
import pe.gob.mimp.seguridad.model.UsuarioBeneficencia;
import pe.gob.mimp.seguridad.repository.usuariobeneficencia.UsuarioBenRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UsuarioBeneficenciaServiceImpl implements UsuarioBeneficenciaService {

    @Autowired
    private UsuarioBenRepository usuarioBeneficenciaRepository;

    @Override
    public List<UsuarioBeneficenciaBean> findByParams(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean == null) {
            return null;
        }

        List<UsuarioBeneficencia> usuarioBeneficenciaList = usuarioBeneficenciaRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (Util.esListaVacia(usuarioBeneficenciaList)) {
            return null;
        }

        return usuarioBeneficenciaList.stream().map(usuarioBeneficencia -> {
            return UsuarioBeneficenciaCast.castUsuarioBeneficenciaToUsuarioBeneficenciaBean(usuarioBeneficencia);
        }).collect(Collectors.toList());

    }

}
