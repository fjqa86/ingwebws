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

@Component
@Path("Device")
public class DeviceWS {

	@Autowired
	private IDevicesBL deviceBL;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Device> list() {
		try {
			return deviceBL.list();
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}

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

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(Device Device) {
		try {
			deviceBL.update(Device);
			return "Almacenado con èxito";
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}

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
