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
import pe.gob.mimp.ms.seguridad.bean.entidades.AreaBean;
import pe.gob.mimp.ms.seguridad.converter.AreaCast;
import pe.gob.mimp.ms.seguridad.service.AreaService;
import pe.gob.mimp.ms.seguridad.util.Util;
import pe.gob.mimp.seguridad.model.Area;
import pe.gob.mimp.seguridad.repository.area.AreaRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<AreaBean> findAll() throws Exception {

        List<Area> areaList = areaRepository.findAll();

        if (Util.esListaVacia(areaList)) {
            return null;
        }

        return areaList.stream().map(area -> {
            return AreaCast.castAreaToAreaBean(area);
        }).collect(Collectors.toList());
    }
    
    @Override
    public AreaBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<Area> area = areaRepository.findById(id);

        if (!area.isPresent()) {
            return null;
        }

        return AreaCast.castAreaToAreaBean(area.get());
    }

    @Override
    public List<AreaBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<Area> areaList = areaRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());

        if (Util.esListaVacia(areaList)) {
            return null;
        }

        return areaList.stream().map(area -> {
            return AreaCast.castAreaToAreaBean(area);
        }).collect(Collectors.toList());
    }


}
