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
import pe.gob.mimp.ms.seguridad.bean.FindAllByFieldBean;
import pe.gob.mimp.ms.seguridad.bean.UsuarioModuloBean;
import pe.gob.mimp.ms.seguridad.bean.ResponseData;
import pe.gob.mimp.ms.seguridad.bean.ValidarBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.FuncionalidadBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.ModuloBean;
import pe.gob.mimp.ms.seguridad.bean.entidades.UsuarioBean;
import pe.gob.mimp.ms.seguridad.service.UsuarioService;

/**
 *
 * @author Omar
 */
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/crearUsuario", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearUsuario(@RequestBody UsuarioBean usuarioNuevoBean) throws Exception {

        usuarioService.crearUsuario(usuarioNuevoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarUsuario", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarUsuario(@RequestBody UsuarioBean usuarioEditadoBean) throws Exception {

        usuarioService.editarUsuario(usuarioEditadoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<ResponseData<?>> findAll() throws Exception {

        List<UsuarioBean> usuarioBeanList = usuarioService.findAll();

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(usuarioBeanList);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        UsuarioBean usuarioBean = usuarioService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(usuarioBean);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/findAllByField", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> findAllByField(@RequestBody FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<UsuarioBean> usuarioBeanList = usuarioService.findAllByField(findAllByFieldBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(usuarioBeanList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getEntidadesModulo", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getEntidadesModulo(@RequestBody ModuloBean moduloBean) throws Exception {

        List<UsuarioBean> usuarioBeanList = usuarioService.getEntidadesModulo(moduloBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(usuarioBeanList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/validar", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> validar(@RequestBody ValidarBean validarBean) throws Exception {

        List<UsuarioBean> usuarioBeanList = usuarioService.validar(validarBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(usuarioBeanList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/obtenerFuncionalidades", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> obtenerFuncionalidades(@RequestBody UsuarioModuloBean usuarioModuloBean) throws Exception {

        List<FuncionalidadBean> funcionalidadBeanList = usuarioService.obtenerFuncionalidades(usuarioModuloBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(funcionalidadBeanList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getEntidadesModuloTodos", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getEntidadesModuloTodos(@RequestBody ModuloBean moduloBean) throws Exception {

        List<UsuarioBean> usuarioBeanList = usuarioService.getEntidadesModuloTodos(moduloBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(usuarioBeanList);

        return ResponseEntity.ok(response);

    }
}
