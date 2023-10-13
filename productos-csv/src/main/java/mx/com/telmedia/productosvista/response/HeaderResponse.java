package mx.com.telmedia.productosvista.response;

import java.io.Serializable;

public class HeaderResponse implements Serializable{
	
	private final static long serialVersionUID = 12345678945613L;

    private String mensaje;
    private boolean estatus;
    private String uid;
    private Integer code;

    public HeaderResponse() {
    }

    public HeaderResponse(String mensaje, boolean estatus, String uid, Integer code) {
        this.mensaje = mensaje;
        this.estatus = estatus;
        this.uid = uid;
        this.code = code;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "HeaderResponse{" +
                "mensaje='" + mensaje + '\'' +
                ", estatus=" + estatus +
                ", uid='" + uid + '\'' +
                ", code=" + code +
                '}';
    }
}
