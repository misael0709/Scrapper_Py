package mx.com.telmedia.productosvista.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.telmedia.productosvista.persistence.EspecificacionesRepo;
import mx.com.telmedia.productosvista.persistence.ImagenesRepo;
import mx.com.telmedia.productosvista.persistence.entities.CSV;
import mx.com.telmedia.productosvista.persistence.entities.Especificaciones;
import mx.com.telmedia.productosvista.persistence.entities.Imagenes;
import mx.com.telmedia.productosvista.persistence.ProductosRepository;
import mx.com.telmedia.productosvista.persistence.entities.Productos;

@Service
public class ProductoscsvistaService {

	@Autowired
	private ProductosRepository productosrepository;
	@Autowired
	private ImagenesRepo imgRepository;
	@Autowired
	private EspecificacionesRepo EspRepository;

	/* Prueba said */
	public List<Productos> Lista() {
		try {

			List<Imagenes> ListImg = null;
			List<Especificaciones> ListEp = null;
			List<Productos> ListProd = productosrepository.findProductos();
			
			for (Productos P : ListProd) {
				ListImg = imgRepository.findById_sku(P.getId_sku());
				for (Imagenes I : ListImg) {
					P.setD_url(P.getD_url() + "http://tm6.telmedia.com.mx" + I.getD_url() + ",");
				}
				ListEp = EspRepository.findBySku(P.getId_sku());
				for (Especificaciones Ep : ListEp) {
					P.setD_nombre_especificacion(P.getD_nombre_especificacion() + "," + Ep.getD_nombre_especificacion());
					P.setD_valor_especificacion(P.getD_valor_especificacion() + "," + Ep.getD_valor_especificacion());
				}
				
				if (P.getN_inventario_cant() != null) {
					P.setN_inventario_cant(P.getN_inventario_cant());
				} else {
					P.setN_inventario_cant("");
				}
				if (P.getN_inventario_cant() != null) {
					P.setN_cant_inventario_bajo(P.getN_cant_inventario_bajo());
				} else {
					P.setN_cant_inventario_bajo("");
				}
				if (P.getN_precio_rebaja() != null) {
					P.setN_precio_rebaja(P.getN_precio_rebaja());
				} else {
					P.setN_precio_rebaja("");
				}
			}
			return ListProd;
		} catch (Exception e) {
			throw new InternalError("Error al consultar productos. " + e.getMessage());
		}
	}

	public List<String[]> toArray(List<Productos> ListProd,int contaespe,HashMap<String,List<Especificaciones>> mapE) {
		
		String p[] = new String[31];
		List<String[]> Prod = new ArrayList<String[]>();
		List<Especificaciones> EpList = null;
		List<Imagenes> ListImg = null;

		for (Productos prod : ListProd) {
			ListImg = imgRepository.findById_sku(prod.getId_sku());
			EpList = mapE.get(prod.getId_sku());
			int arreglo = 0;
			for (Imagenes I : ListImg) {
				prod.setD_url(prod.getD_url() + "http://tm6.telmedia.com.mx" + I.getD_url() + ",");
			}
			p[0] = ""; // ID
			p[1] = prod.getD_tipo();
			p[2] = prod.getId_sku();
			p[3] = prod.getD_nombre_sku();
			p[4] = prod.getB_publicar();// publicado;
			p[5] = prod.getB_destacar();// destacado;
			p[6] = prod.getD_visibilidad();
			p[7] = prod.getD_descripcion();
			p[8] = prod.getD_caracteristicas();
			p[9] = prod.getF_fecha_inicio_rebaja();// fechaini;
			p[10] = prod.getF_fecha_fin_rebaja();// fechafin;
			p[11] = prod.getD_impuesto();// d_impuesto;
			p[12] = ""; // clase de impuesto
			p[13] = prod.getB_en_catalogo();// eninv;
			p[14] = prod.getN_inventario_cant();
			p[15] = prod.getN_cant_inventario_bajo();
			p[16] = prod.getB_permitir_reservar();//
			p[17] = prod.getB_venta_individual();// vIndiv;
			p[18] = ""; // peso
			p[19] = ""; // longitud
			p[20] = ""; // ancho
			p[21] = ""; // altura
			p[22] = prod.getB_valoracion_clientes();// valoracion;
			p[23] = ""; // nota de compras
			p[24] = prod.getN_precio_rebaja();
			p[25] = prod.getN_precio_publico();
			p[26] = prod.getD_categoria_principal();
			p[27] = ""; // etiquetas
			p[28] = ""; // clase de envio
			p[29] = prod.getD_url();
			p[30] = "";// posicion
			
			String e[] = new String[(contaespe*4)];
			for(int contar = 0;contar<=(contaespe-1);contar++) {
				
				if(contar < EpList.size()) {
					//prod.setD_nombre_especificacion(EpList.get(contar).getD_nombre_especificacion());
					//prod.setD_valor_especificacion(EpList.get(contar).getD_valor_especificacion());
					e[arreglo++] = EpList.get(contar).getD_nombre_especificacion();//prod.getD_nombre_especificacion();
					e[arreglo++] = EpList.get(contar).getD_valor_especificacion();//prod.getD_valor_especificacion();
					e[arreglo++] = "1";
					e[arreglo++] = "1";
				}else {
					e[arreglo++] = "";
					e[arreglo++] = "";
					e[arreglo++] = "";
					e[arreglo++] = "";
				}
			}
			String[] res = new String[31 + (contaespe*4)];
			System.arraycopy(p, 0, res, 0, p.length);
			System.arraycopy(e, 0, res, p.length, e.length);
			
			Prod.add(res);
			
		}
		
		return Prod;
	}
	
	public CSV generaCsv() {
		CSV csv = new CSV();
		List<Productos> ListProd = productosrepository.findProductos();
		
		int contaespe = 0;
		List<Especificaciones> EpList = null;
		HashMap <String,List<Especificaciones>> mapE = new HashMap <String,List<Especificaciones>>();
		for (Productos prod : ListProd) {
			EpList = EspRepository.findBySku(prod.getId_sku());
			mapE.put(prod.getId_sku(), EpList);
			if(!EpList.isEmpty()) {
				if(EpList.size() > contaespe) {
					contaespe = EpList.size();
				}
			}
		}
		
		String[] header = { "id", "type", "sku", "name", "published", "is featured?", "visibility in catalog",
				"short description", "description", "date sale price starts", "date sale price ends", "tax status", "tax class",
				"in stock?", "stock", "low stock amount", "backorders allowed?", "sold individually?", "weight (kg)",
				"length (cm)", "width (cm)", "height (cm)", "allow customer reviews?", "purchase note", "sale price",
				"regular price", "categories", "tags", "shipping class", "Images", "position"};

		
		String[] headerespe = new String[contaespe*4];
		int arreglopos=0;
		int poscsv=1;
		for(int cont=1;cont<=contaespe;cont++) {
			
			headerespe[arreglopos++] = "attribute "+poscsv+" name";
			headerespe[arreglopos++] = "attribute "+poscsv+" value(s)";
			headerespe[arreglopos++] = "attribute "+poscsv+" visible";
			headerespe[arreglopos++] = "attribute "+poscsv+" global";
			poscsv++;
			
		}
		String [] headertotal = (String[])ArrayUtils.addAll(header, headerespe);
		csv.setHeader(headertotal);
		
		csv.setCuerpo(toArray(ListProd,contaespe,mapE));
		return csv;
	}
}
