package com.ingweb.prestamoequipos.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
		
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/login")
		public boolean login(@QueryParam("user") String userId,@QueryParam("pass") String pass){
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
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/lostpassword")
		public void recuperarContrasena(User user){
			try{
				userBL.lostPassword(user);
			}catch (Exception e){
				throw new WSException(e.getMessage());
			}
		}
		
		@PUT
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/changepassword")
		public String cambiarContrasena(@QueryParam("iduser") String idUser,
				@QueryParam("oldpass") String oldPassword,
				@QueryParam("newpass") String newPassword){
			try {
				userBL.changePassword(idUser, oldPassword, newPassword);
				return "La contrasena fue cambiada con èxito";
			} catch (Exception e) {
				throw new WSException(e.getMessage());
			}
		}

}
