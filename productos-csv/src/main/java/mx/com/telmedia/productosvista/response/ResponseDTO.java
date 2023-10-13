package mx.com.telmedia.productosvista.response;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;


public class ResponseDTO implements Serializable {
private static final long serialVersionUID = 601685887885973603L;
    
    /*@Autowired
    private HeaderResponse headerResponse;*/
    
    @Autowired
	private Payload payload;
    
    /*@Autowired
    private Summary summary;*/
    
    

	public ResponseDTO(/*HeaderResponse headerResponse*/ Payload payload /*Summary summary*/) { //una opcion
		this.payload = payload;
		/*this.headerResponse = headerResponse;
		this.summary = summary;*/
	}
    public ResponseDTO() {}


    /*public HeaderResponse getHeaderResponse() {
		return headerResponse;
	}

	public void setHeaderResponse(HeaderResponse headerResponse) {
		this.headerResponse = headerResponse;
	}	*/

    public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	
	/*public Summary getSummary() {
		return summary;
	}
	public void setSummary(Summary summary) {
		this.summary = summary;
	}*/
	@Override
    public String toString() {
        return "RespuestaDTO{" + "body=" + payload + '}';
                /*"headerResponse=" + headerResponse +*/
                /*", summary= " + summary +*/
                
    }

}

