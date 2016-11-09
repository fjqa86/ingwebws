package com.ingweb.prestamoequipos.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class WSException extends WebApplicationException {

    public WSException(String message) {
        super(Response.status(400).header("error", message).
                entity(message).type("text/plain").build());
    }

    public WSException(String message, Response.Status status) {
        super(message, status);
    }
}
