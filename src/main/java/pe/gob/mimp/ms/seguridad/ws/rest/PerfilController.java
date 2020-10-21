/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.ms.seguridad.bean.ResponseData;
import pe.gob.mimp.ms.seguridad.bean.UsuarioModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.ModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.PerfilBean;
import pe.gob.mimp.ms.seguridad.service.PerfilService;

/**
 *
 * @author Omar
 */
@RestController
@RequestMapping(value = "/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PostMapping(value = "/obtenerPerfiles", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> obtenerPerfiles(@RequestBody UsuarioModuloBean usuarioModuloBean) throws Exception {

        List<PerfilBean> perfilBeanList = perfilService.obtenerPerfiles(usuarioModuloBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(perfilBeanList);

        return ResponseEntity.ok(response);

    }
    
    @PostMapping(value = "/obtenerPerfilesDelModulo", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> obtenerPerfilesDelModulo(@RequestBody ModuloBean moduloBean) throws Exception {

        List<PerfilBean> perfilBeanList = perfilService.obtenerPerfilesDelModulo(moduloBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(perfilBeanList);

        return ResponseEntity.ok(response);

    }
    
    @GetMapping(value = "/findAll")
    public ResponseEntity<ResponseData<?>> findAll() throws Exception {

        List<PerfilBean> perfilBeanList = perfilService.findAll();

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(perfilBeanList);

        return ResponseEntity.ok(response);

    }
    
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        PerfilBean perfilBean = perfilService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(perfilBean);

        return ResponseEntity.ok(response);

    }
}
