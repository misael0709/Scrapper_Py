package mx.com.telmedia.productosvista.utils.exception;

public class BusinessException extends Exception {


	private static final long serialVersionUID = 1L;

	private String mensaje;

	public BusinessException(String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}

	public BusinessException(String mensaje, Throwable causa){
		super(mensaje, causa);
		this.mensaje = mensaje;
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
}
