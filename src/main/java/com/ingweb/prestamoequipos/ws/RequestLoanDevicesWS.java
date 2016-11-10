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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RequestLoanDevices> pendingList() {
		try {
			return requestLoanDevicesBL.getPendingList();
		} catch (Exception e) {
			throw new WSException(e.getMessage());
		}
	}
	
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
