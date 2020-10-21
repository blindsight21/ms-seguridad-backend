/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.service;

import java.math.BigDecimal;
import pe.gob.mimp.ms.seguridad.bean.entidades.ModuloBean;

/**
 *
 * @author Omar
 */
public interface ModuloService {

    ModuloBean find(BigDecimal id) throws Exception;
}
