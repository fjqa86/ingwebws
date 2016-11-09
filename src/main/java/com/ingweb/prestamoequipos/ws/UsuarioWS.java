package com.ingweb.prestamoequipos.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingweb.prestamoequipos.bl.IUserBL;
import com.ingweb.prestamoequipos.exception.WSException;
import com.ingweb.prestamoequipos.model.User;
@Component
@Path("usuario")
public class UsuarioWS {

	@Autowired
		private IUserBL userBL;
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/login/{user}/{pass}")
		public boolean login(@PathParam("user") String userId,@PathParam("pass") String pass){
			try{
				User user = new User();
				user.setIdUser(userId);
				user.setPassword(pass);
				if( userBL.login(user)){
					return true;
				}else{
					throw new WSException("Usuario o contraseña no valida.");
				}
			}catch (Exception e) {
				throw new WSException(e.getMessage());
			}
		}
		
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/sigup")
		public void signup(User user){
			try{
				userBL.signUp(user);
			}catch (Exception e) {
				throw new WSException(e.getMessage());
			}
			
		}

}
