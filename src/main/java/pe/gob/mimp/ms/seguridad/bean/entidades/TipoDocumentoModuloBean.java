/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.seguridad.bean.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import pe.gob.mimp.ms.seguridad.util.FormatoFechaConstante;

/**
 *
 * @author desarrollador
 */
public class TipoDocumentoModuloBean implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal nidTipoDocumentoModulo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigInteger flgActivo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigInteger nidUsuario;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String txtPc;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String txtIp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = FormatoFechaConstante.yyyyMMddTHHmmssSSSXXX, timezone = FormatoFechaConstante.ZONA_HORARIA)
    private Date fecEdicion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigInteger nidTipoDocumento;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigInteger nidModulo;

    public BigDecimal getNidTipoDocumentoModulo() {
        return nidTipoDocumentoModulo;
    }

    public void setNidTipoDocumentoModulo(BigDecimal nidTipoDocumentoModulo) {
        this.nidTipoDocumentoModulo = nidTipoDocumentoModulo;
    }

    public BigInteger getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(BigInteger flgActivo) {
        this.flgActivo = flgActivo;
    }

    public BigInteger getNidUsuario() {
        return nidUsuario;
    }

    public void setNidUsuario(BigInteger nidUsuario) {
        this.nidUsuario = nidUsuario;
    }

    public String getTxtPc() {
        return txtPc;
    }

    public void setTxtPc(String txtPc) {
        this.txtPc = txtPc;
    }

    public String getTxtIp() {
        return txtIp;
    }

    public void setTxtIp(String txtIp) {
        this.txtIp = txtIp;
    }

    public Date getFecEdicion() {
        return fecEdicion;
    }

    public void setFecEdicion(Date fecEdicion) {
        this.fecEdicion = fecEdicion;
    }

    public BigInteger getNidTipoDocumento() {
        return nidTipoDocumento;
    }

    public void setNidTipoDocumento(BigInteger nidTipoDocumento) {
        this.nidTipoDocumento = nidTipoDocumento;
    }

    public BigInteger getNidModulo() {
        return nidModulo;
    }

    public void setNidModulo(BigInteger nidModulo) {
        this.nidModulo = nidModulo;
    }

}
