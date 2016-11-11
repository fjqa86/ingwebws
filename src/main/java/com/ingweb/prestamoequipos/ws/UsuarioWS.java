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

/**
 * Clase para manejo de peticiones rest para usuario
 * @author javier.quintero@udea.edu.co
 *
 */
@Component
@Path("usuario")
public class UsuarioWS {

	@Autowired
		private IUserBL userBL;
		
	/**
	 * Valida si un usuario es permitido para la aplicación
	 * @param user idUser y password a validar
	 * @return status 200 o error con mensaje status 400
	 */
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/login")
		public boolean login(User user){
			try{
				if( userBL.login(user)){
					return true;
				}else{
					throw new WSException("Usuario o contraseña no valida.");
				}
			}catch (Exception e) {
				throw new WSException(e.getMessage());
			}
		}
		
		/**
		 * Alamcena un usuario nuevo en la base de datos
		 * @param user usuario al macenar
		 * return status 200 0 error con mensaje status 400
		 */
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
		
		/**
		 * Busca un correo en la base de datos, cambia la contraseña y envia un correo con el password nuevo.
		 * @param user idUser correo electronico
		 * @return mensaje status 200 o error con mensaje status 400
		 */
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/lostpassword")
		public String recuperarContrasena(User user){
			try{
				userBL.lostPassword(user);
				return "Hemos enviado un correo con tu nueva contraseña";
			}catch (Exception e){
				throw new WSException(e.getMessage());
			}
		}
		
		@PUT
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/changepassword/")
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
