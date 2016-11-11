package com.ingweb.prestamoequipos.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingweb.prestamoequipos.bl.IRequestLoanDevicesBL;
import com.ingweb.prestamoequipos.exception.WSException;
import com.ingweb.prestamoequipos.model.RequestLoanDevices;

@Component
@Path("request")
public class RequestLoanDevicesWS {

	@Autowired
	private IRequestLoanDevicesBL requestLoanDevicesBL;
	
	/**
	 * Guarda una solicitud de dipositivo a prestar en la base de datos
	 * @param requestLoanDevices  en formato json
	 * @return mensaje status 200 o error con mensaje status 400 
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String save(RequestLoanDevices requestLoanDevices) {
		try {
			requestLoanDevicesBL.save(requestLoanDevices);
			return "Almacenado con èxito";
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	
	/**
	 * Lista solicitudes de dipositivo a prestar almacenados en la base de datos
	 * @return listado solicitudes de dipositivo a prestar status 200 o error con mensaje status 400 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RequestLoanDevices> pendingList() {
		try {
			return requestLoanDevicesBL.getPendingList();
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	
	
	/**
	 * Permite aceptar una solicitud de préstamo almacenada en la base de datos
	 * @param requestLoanDevices
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void aceptar(RequestLoanDevices requestLoanDevices) {
		try {
			requestLoanDevicesBL.acceptRequest(requestLoanDevices);;
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	
}
