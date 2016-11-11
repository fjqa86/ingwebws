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


@Component
@Path("rol")
public class RolWS {
	
	@Autowired
	private IRolBL rolBL;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rol> getRoles(){
		try{
		 return rolBL.list();
		}catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	
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
