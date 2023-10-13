package mx.com.telmedia.productosvista;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import mx.com.telmedia.productosvista.persistence.ProductosRepository;

@SpringBootApplication
public class ProductoscsvistaApplication extends SpringBootServletInitializer{
	@Autowired
	ProductosRepository productosR; 
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProductoscsvistaApplication.class);

    }
	
	public static void main(String[] args) {
		SpringApplication.run(ProductoscsvistaApplication.class, args);
	}
	
	

}
