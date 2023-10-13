package mx.com.telmedia.productosvista.response;

import java.io.Serializable;

public class Summary implements Serializable {
	
	private final static long serialVersionUID = 12345678945613L;
	
	private long noRegistros;
    private Integer noPagina;
    private Integer totalPaginas;
    private Integer tamanoPagina;
    
    public Summary() {
    	
    }
    
    public Summary(long noRegistros, Integer noPagina, Integer totalPaginas, Integer tamanoPagina) {
    	this.noRegistros = noRegistros;
    	this.noPagina = noPagina;
    	this.totalPaginas = totalPaginas;
    	this.tamanoPagina = tamanoPagina;
    	
    }

	public long getNoRegistros() {
		return noRegistros;
	}

	public void setNoRegistros(long noRegistros) {
		this.noRegistros = noRegistros;
	}

	public Integer getNoPagina() {
		return noPagina;
	}

	public void setNoPagina(Integer noPagina) {
		this.noPagina = noPagina;
	}

	public Integer getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(Integer totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public Integer getTamanoPagina() {
		return tamanoPagina;
	}

	public void setTamanoPagina(Integer tamanoPagina) {
		this.tamanoPagina = tamanoPagina;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Summary{" +
				"noRegistros='" + noRegistros + '\'' +
				", noPagina=" + noPagina +
				", totalPaginas='" + totalPaginas + '\'' +
				", tamanoPagina=" + tamanoPagina + 
				'}';
	}
    
}
