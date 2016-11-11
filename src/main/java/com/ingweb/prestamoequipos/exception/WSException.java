package com.ingweb.prestamoequipos.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
/**
 * Manejo de excepciones
 * @author giovanny gomez @gio96gomez@gmail.com
 *@author francisco quintero @javier.quintero@udea.edu.co
 *@author juan david reyes @jdavid.reyes@udea.edu.co
 */
public class WSException extends WebApplicationException {

    public WSException(String message) {
        super(Response.status(400).header("error", message).
                entity(message).type("text/plain").build());
    }

    public WSException(String message, Response.Status status) {
        super(message, status);
    }
}
