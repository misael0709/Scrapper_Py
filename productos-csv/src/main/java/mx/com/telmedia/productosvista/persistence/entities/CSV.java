package mx.com.telmedia.productosvista.persistence.entities;

import java.util.ArrayList;
import java.util.List;

public class CSV {

	String[] header= {};
	List<String[]> cuerpo = new ArrayList<String[]>();
	
	
	public String[] getHeader() {
		return header;
	}
	public void setHeader(String[] header) {
		this.header = header;
	}
	public List<String[]> getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(List<String[]> cuerpo) {
		this.cuerpo = cuerpo;
	}
}
