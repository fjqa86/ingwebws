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

@Component
@Path("brand")
public class BrandWS {

	@Autowired
	private IBrandBL brandBL;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Brand> list() {
		try {
			return brandBL.list();
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}

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
