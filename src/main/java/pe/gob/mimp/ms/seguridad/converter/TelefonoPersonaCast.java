/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.converter;

import java.math.BigInteger;
import pe.gob.mimp.ms.seguridad.bean.entidades.TelefonoPersonaBean;
import pe.gob.mimp.seguridad.model.TelefonoPersona;

/**
 *
 * @author Omar
 */
public class TelefonoPersonaCast {

    public static TelefonoPersonaBean castTelefonoPersonaToTelefonoPersonaBean(TelefonoPersona telefonoPersona) {

        if (telefonoPersona == null) {
            return null;
        }

        TelefonoPersonaBean telefonoPersonaBean = new TelefonoPersonaBean();

        telefonoPersonaBean.setNidTelefonoPersona(telefonoPersona.getNidTelefonoPersona());
        telefonoPersonaBean.setTxtTelefonoPersona(telefonoPersona.getTxtTelefonoPersona());
        telefonoPersonaBean.setNidPersona(telefonoPersona.getNidPersona());
        telefonoPersonaBean.setFlgActivo(telefonoPersona.getFlgActivo());
        telefonoPersonaBean.setNidUsuario(telefonoPersona.getNidUsuario());
        telefonoPersonaBean.setTxtPc(telefonoPersona.getTxtPc());
        telefonoPersonaBean.setTxtIp(telefonoPersona.getTxtIp());
        telefonoPersonaBean.setFecEdicion(telefonoPersona.getFecEdicion());
        telefonoPersonaBean.setTipoTelefonoBean(null);

        return telefonoPersonaBean;
    }

    public static TelefonoPersona castTelefonoPersonaBeanToTelefonoPersona(TelefonoPersonaBean telefonoPersonaBean) {

        if (telefonoPersonaBean == null) {
            return null;
        }

        TelefonoPersona telefonoPersona = new TelefonoPersona();

        telefonoPersona.setNidTelefonoPersona(telefonoPersonaBean.getNidTelefonoPersona());
        telefonoPersona.setTxtTelefonoPersona(telefonoPersonaBean.getTxtTelefonoPersona());
        telefonoPersona.setNidPersona(telefonoPersonaBean.getNidPersona());
        telefonoPersona.setFlgActivo(telefonoPersonaBean.getFlgActivo());
        telefonoPersona.setNidUsuario(telefonoPersonaBean.getNidUsuario());
        telefonoPersona.setTxtPc(telefonoPersonaBean.getTxtPc());
        telefonoPersona.setTxtIp(telefonoPersonaBean.getTxtIp());
        telefonoPersona.setFecEdicion(telefonoPersonaBean.getFecEdicion());
        telefonoPersona.setTipoTelefono(null);

        return telefonoPersona;
    }
}
