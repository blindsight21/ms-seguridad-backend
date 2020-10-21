/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.ms.seguridad.bean.entidades.TipoDocumentoBean;
import pe.gob.mimp.seguridad.model.TipoDocumento;

/**
 *
 * @author Omar
 */
public interface TipoDocumentoService {

    void crearTipoDocumento(TipoDocumentoBean tipoDocumentoBean) throws Exception;

    void editarTipoDocumento(TipoDocumentoBean tipoDocumentoBean) throws Exception;

//    void anularTipoDocumento(TipoDocumento tipoDocumento) throws Exception;
    String obtenerTipoDocumentoPorId(BigDecimal nidTipoDocumento) throws Exception;

    List<TipoDocumentoBean> findAll() throws Exception;

    TipoDocumentoBean obtener(String nombre) throws Exception;
    
    TipoDocumentoBean find(BigDecimal id) throws Exception;
}
