package mx.com.telmedia.productosvista.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opencsv.CSVWriter;

import mx.com.telmedia.productosvista.persistence.entities.CSV;
import mx.com.telmedia.productosvista.persistence.entities.Productos;
import mx.com.telmedia.productosvista.response.ProductosResponse;
import mx.com.telmedia.productosvista.response.ResponseDTO;
import mx.com.telmedia.productosvista.service.ProductoscsvistaService;
import mx.com.telmedia.productosvista.utils.BeanValidator;
import mx.com.telmedia.productosvista.utils.GUIDGenerator;
import mx.com.telmedia.productosvista.utils.LogHandler;


@Controller
@RequestMapping("/productos")
public class ProductoscsvistaController {
	@Autowired
	ProductoscsvistaService productoscsvistaService;
	
	/* Prueba said */
	@GetMapping("/Lista/")
	public ResponseEntity<ResponseDTO> Lista() {
		String uid = GUIDGenerator.generateGUID();
		LogHandler.info(uid, getClass(), "Inicia Consultar Listado de modulos ");
		try {
			ProductosResponse productoscsvistaResponse = new ProductosResponse();
			productoscsvistaResponse.setProductos(productoscsvistaService.Lista());
			ResponseDTO responseDTO = new ResponseDTO(productoscsvistaResponse);
			return new ResponseEntity<>(responseDTO, HttpStatus.OK);
		} catch (Exception e) {
			return BeanValidator.validaException(e, uid);
		}
	}

	@GetMapping("/index")
	public String welcome(Model model) {
		// Consulta General
		List<Productos> ListProd = productoscsvistaService.Lista();
		model.addAttribute("prodService", ListProd);

		return "pagina";

	}

	@GetMapping("/export-csv")
	public String prodCsv(HttpServletResponse response) throws IOException {

		String csvFileName = "productos.csv";
		//response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
		response.setHeader(headerKey, headerValue);
		response.setCharacterEncoding("utf-8");
		CSVWriter writer = new CSVWriter(response.getWriter());
		CSV csv = productoscsvistaService.generaCsv();
		writer.writeNext(csv.getHeader());
		writer.writeAll(csv.getCuerpo());
		writer.close();
		return "pagina";
	}

}
