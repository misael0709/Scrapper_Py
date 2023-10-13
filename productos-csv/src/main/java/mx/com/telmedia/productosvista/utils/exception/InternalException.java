package mx.com.telmedia.productosvista.utils.exception;

public class InternalException extends Exception{
	
	 private static final long serialVersionUID = 4925043552853314651L;
	 
	 private String mensaje;
	 
	 public InternalException(String mensaje){
	        super(mensaje);
	        this.mensaje = mensaje;
	    }
	    public InternalException(String mensaje, Throwable causa){
	        super(mensaje, causa);
	        this.mensaje = mensaje;
	    }

	    public String getMensaje() {
	        return mensaje;
	    }

	    public void setMensaje(String mensaje) {
	        this.mensaje = mensaje;
	    }



}