/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.ws.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.ms.seguridad.bean.ResponseData;
import pe.gob.mimp.ms.seguridad.bean.entidades.CorreoPersonaBean;
import pe.gob.mimp.ms.seguridad.service.CorreoPersonaService;

/**
 *
 * @author Omar
 */
@RestController
@RequestMapping(value = "/correopersona")
public class CorreoPersonaController {

    @Autowired
    private CorreoPersonaService correoPersonaService;

    @PostMapping(value = "/crearCorreoPersona", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearCorreoPersona(@RequestBody CorreoPersonaBean correoPersonaBeanNuevo) throws Exception {

        correoPersonaService.crearCorreoPersona(correoPersonaBeanNuevo);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

}
