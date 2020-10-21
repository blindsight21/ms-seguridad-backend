/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service.impl;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.ms.seguridad.bean.entidades.ModuloBean;
import pe.gob.mimp.ms.seguridad.converter.ModuloCast;
import pe.gob.mimp.ms.seguridad.service.ModuloService;
import pe.gob.mimp.seguridad.model.Modulo;
import pe.gob.mimp.seguridad.repository.modulo.ModuloRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ModuloServiceImpl implements ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    @Override
    public ModuloBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<Modulo> modulo = moduloRepository.findById(id);

        if (!modulo.isPresent()) {
            return null;
        }

        return ModuloCast.castModuloToModuloBean(modulo.get());
    }
}
