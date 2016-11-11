package com.ingweb.prestamoequipos.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingweb.prestamoequipos.bl.IBrandBL;
import com.ingweb.prestamoequipos.exception.WSException;
import com.ingweb.prestamoequipos.model.Brand;


/**
 * Clase para el manejo de peticiones rest para las marcas
 * @author giovanny gomez @gio96gomez@gmail.com
 *@author francisco quintero @javier.quintero@udea.edu.co
 *@author juan david reyes @jdavid.reyes@udea.edu.co
 */
@Component
@Path("brand")
public class BrandWS {

	@Autowired
	private IBrandBL brandBL;

	/**
	 * Lista las marcas almacenadas en la base de datos
	 * 
	 * @return listado de marcas status 200 o error con mensaje status 400 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Brand> list() {
		try {
			return brandBL.list();
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	
	/**
	 * Guarda una marca en la base de datos
	 * @param brand marca en formato json
	 * @return mensaje status 200 o error con mensaje status 400 
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String save(Brand brand) {
		try {
			brandBL.save(brand);
			return "Almacenado con èxito";
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}

	/**
	 * Actualiza una marca en la base de datos
	 * @param brand marca en formato json
	 * @return mensaje status 200 o error con mensaje status 400 
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(Brand brand) {
		try {
			brandBL.update(brand);
			return "Almacenado con èxito";
		} catch (Exception e) {
			throw new WSException(e.getMessage());
			// TODO: handle exception
		}
	}
	
	

	@DELETE
	@Path("/{id}")
	public String delete(@PathParam("id") Integer id) {
		return "No disponible";
	}
}
