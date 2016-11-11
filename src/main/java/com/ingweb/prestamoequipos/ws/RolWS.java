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

import com.ingweb.prestamoequipos.bl.IRolBL;
import com.ingweb.prestamoequipos.model.Rol;
import com.ingweb.prestamoequipos.exception.WSException;

/**
 * Clase para manejo de peticiones rest para rol
 * @author giovanny gomez @gio96gomez@gmail.com
 *@author francisco quintero @javier.quintero@udea.edu.co
 *@author juan david reyes @jdavid.reyes@udea.edu.co
 */

@Component
@Path("rol")
public class RolWS {
	
	@Autowired
	private IRolBL rolBL;
	/**
	 * Lista los roles almacenadas en la base de datos
	 * 
	 * @return listado roles status 200 o error con mensaje status 400 
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rol> getRoles(){
		try{
		 return rolBL.list();
		}catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	
	/**
	 * Guarda un rol en la base de datos
	 * @param rol  en formato json
	 * @return mensaje status 200 o error con mensaje status 400 
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String save(Rol rol){
		try{
			rolBL.save(rol);
			return "Almaceno con éxito";
		}catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	
	/**
	 * Actualiza un rol en la base de datos
	 * @param rol en formato json
	 * @return mensaje status 200 o error con mensaje status 400 
	 */
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(Rol rol){
		try{
			rolBL.update(rol);
			return "Actualizo con éxito";
		}catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	
	/**
	 * Elimina un rol en la base de datos
	 * @param Id rol en formato json
	 * @return mensaje status 200 o error con mensaje status 400
	 */
	@DELETE
	@Path("/{id}")
	public String delete(@PathParam("id") Integer id){
		try{
			return "NO DISPONIBLE";
		}catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	

}
