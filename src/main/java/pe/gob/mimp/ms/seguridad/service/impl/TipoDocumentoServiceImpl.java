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
import pe.gob.mimp.ms.seguridad.bean.entidades.TipoDocumentoBean;
import pe.gob.mimp.ms.seguridad.converter.TipoDocumentoCast;
import pe.gob.mimp.ms.seguridad.service.TipoDocumentoService;
import pe.gob.mimp.ms.seguridad.util.Util;
import pe.gob.mimp.seguridad.model.TipoDocumento;
import pe.gob.mimp.seguridad.repository.tipodocumento.TipoDocumentoRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public void crearTipoDocumento(TipoDocumentoBean tipoDocumentoBeanNuevo) throws Exception {

        TipoDocumento tipoDocumentoNuevo = TipoDocumentoCast.castTipoDocumentoBeanToTipoDocumento(tipoDocumentoBeanNuevo);

        tipoDocumentoRepository.save(tipoDocumentoNuevo);

    }

    @Override
    public void editarTipoDocumento(TipoDocumentoBean tipoDocumentoBeanEditado) {

        if (tipoDocumentoBeanEditado.getNidTipoDocumento() == null) {
            return;
        }

        TipoDocumento tipoDocumentoNuevo = TipoDocumentoCast.castTipoDocumentoBeanToTipoDocumento(tipoDocumentoBeanEditado);

        tipoDocumentoRepository.save(tipoDocumentoNuevo);

    }

    @Override
    public String obtenerTipoDocumentoPorId(BigDecimal nidTipoDocumento) throws Exception {

        Optional<TipoDocumento> tipoDocumento = tipoDocumentoRepository.findById(nidTipoDocumento);

        if (tipoDocumento.isPresent()) {
            return tipoDocumento.get().getTxtDescripcion();
        }

        return "";
    }

    @Override
    public List<TipoDocumentoBean> findAll() throws Exception {

        List<TipoDocumento> tipoDocumentoList = tipoDocumentoRepository.findAll();

        if (Util.esListaVacia(tipoDocumentoList)) {
            return null;
        }

        return tipoDocumentoList.stream().map(tipoDocumento -> {
            return TipoDocumentoCast.castTipoDocumentoToTipoDocumentoBean(tipoDocumento);
        }).collect(Collectors.toList());
    }

    @Override
    public TipoDocumentoBean obtener(String nombre) throws Exception {

        TipoDocumento tipoDocumento = tipoDocumentoRepository.obtener(nombre);

        return TipoDocumentoCast.castTipoDocumentoToTipoDocumentoBean(tipoDocumento);
    }

    @Override
    public TipoDocumentoBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<TipoDocumento> tipoDocumentoSiscap = tipoDocumentoRepository.findById(id);

        if (!tipoDocumentoSiscap.isPresent()) {
            return null;
        }

        return TipoDocumentoCast.castTipoDocumentoToTipoDocumentoBean(tipoDocumentoSiscap.get());
    }
}
