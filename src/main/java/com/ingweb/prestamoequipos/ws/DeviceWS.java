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

import com.ingweb.prestamoequipos.bl.IDevicesBL;
import com.ingweb.prestamoequipos.exception.WSException;
import com.ingweb.prestamoequipos.model.Device;

/**
 * Clase para el manejo de peticiones rest para las equipos
 * @author javier.quintero@udea.edu.co
 *
 */
@Component
@Path("Device")
public class DeviceWS {

	@Autowired
	private IDevicesBL deviceBL;

	/**
	 * Lista los equipos almacenados en la base de datos
	 * @return listado de equipos status 200 o error con mensaje status 400 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Device> list() {
		try {
			return deviceBL.list();
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	/**
	 * Guarda un equipo en la base de datos
	 * @param Device equipo en formato json
	 * @return mensaje status 200 o error con mensaje status 400
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String save(Device Device) {
		try {
			deviceBL.save(Device);
			return "Almacenado con èxito";
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}

	/**
	 * actualiza un equipo en la base de datos
	 * @param Device equipo en formato json
	 * @return mensaje status 200 o error con mensaje status 400
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(Device device) {
		try {
			deviceBL.update(device);
			return "Almacenado con èxito";
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	
	/**
	 * Elimina un equipo en la base de datos
	 * @param Id equipo en formato json
	 * @return mensaje status 200 o error con mensaje status 400
	 */

	@DELETE
	@Path("/{id}")
	public String delete(@PathParam("id") Integer id) {
		try{
			deviceBL.delete(id);
			return "Elimino con èxito";
		}catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
}
