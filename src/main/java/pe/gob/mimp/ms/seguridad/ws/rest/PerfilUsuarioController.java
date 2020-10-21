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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.ms.seguridad.bean.ResponseData;
import pe.gob.mimp.ms.seguridad.bean.UsuarioModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.PerfilUsuarioBean;
import pe.gob.mimp.ms.seguridad.service.PerfilUsuarioService;

/**
 *
 * @author Omar
 */
@RestController
@RequestMapping(value = "/perfilusuario")
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @PostMapping(value = "/crearPerfilUsuario", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearPerfilUsuario(@RequestBody PerfilUsuarioBean perfilUsuarioBeanNuevo) throws Exception {

        perfilUsuarioService.crearPerfilUsuario(perfilUsuarioBeanNuevo);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/obtenerPerfilUsuarioPorModulo", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> obtenerPerfilUsuarioPorModulo(@RequestBody UsuarioModuloBean usuarioModuloBean) throws Exception {

        List<PerfilUsuarioBean> perfilUsuarioBeanList = perfilUsuarioService.obtenerPerfilUsuarioPorModulo(usuarioModuloBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(perfilUsuarioBeanList);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/remove", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> remove(@RequestBody PerfilUsuarioBean perfilUsuarioBeanEliminado) throws Exception {

        perfilUsuarioService.remove(perfilUsuarioBeanEliminado);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

}
