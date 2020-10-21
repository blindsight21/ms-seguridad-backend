/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.mimp.ms.seguridad.bean.ResponseData;
import pe.gob.mimp.ms.seguridad.bean.entidades.TipoDocumentoBean;
import pe.gob.mimp.ms.seguridad.service.TipoDocumentoService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/tipodocumento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @PostMapping(value = "/crearTipoDocumento", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearTipoDocumento(@RequestBody TipoDocumentoBean tipoDocumentoBeanNuevo) throws Exception {

        tipoDocumentoService.crearTipoDocumento(tipoDocumentoBeanNuevo);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarTipoDocumento", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarTipoDocumento(@RequestBody TipoDocumentoBean tipoDocumentoBeanEditado) throws Exception {

        tipoDocumentoService.editarTipoDocumento(tipoDocumentoBeanEditado);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerTipoDocumentoPorId/{nidTipoDocumento}")
    public ResponseEntity<ResponseData<?>> obtenerTipoDocumentoPorId(@PathVariable("nidTipoDocumento") BigDecimal nidTipoDocumento) throws Exception {

        String txtTipoDocumento = tipoDocumentoService.obtenerTipoDocumentoPorId(nidTipoDocumento);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(txtTipoDocumento);

        return ResponseEntity.ok(response);

    }


    @GetMapping(value = "/findAll")
    public ResponseEntity<ResponseData<?>> findAll() throws Exception {

        List<TipoDocumentoBean> tipoDocumentoBeanList = tipoDocumentoService.findAll();

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoDocumentoBeanList);

        return ResponseEntity.ok(response);

    }
    
    @GetMapping(value = "/obtener")
    public ResponseEntity<ResponseData<?>> obtener(@PathVariable("nombre") String nombre) throws Exception {

        TipoDocumentoBean tipoDocumentoBean = tipoDocumentoService.obtener(nombre);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoDocumentoBean);

        return ResponseEntity.ok(response);

    }
    
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        TipoDocumentoBean tipoDocumentoBean = tipoDocumentoService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoDocumentoBean);

        return ResponseEntity.ok(response);

    }

}
