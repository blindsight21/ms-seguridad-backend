/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.ws.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.ms.seguridad.bean.FindAllByFieldBean;
import pe.gob.mimp.ms.seguridad.bean.ResponseData;
import pe.gob.mimp.ms.seguridad.bean.entidades.TipoPersonaBean;
import pe.gob.mimp.ms.seguridad.service.TipoPersonaService;

/**
 *
 * @author Omar
 */
@RestController
@RequestMapping(value = "/tipopersona")
public class TipoPersonaController {

    @Autowired
    private TipoPersonaService tipoPersonaService;

    @PostMapping(value = "/findAllByField", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> findAllByField(@RequestBody FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<TipoPersonaBean> tipoPersonaBeanList = tipoPersonaService.findAllByField(findAllByFieldBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoPersonaBeanList);

        return ResponseEntity.ok(response);

    }
}
