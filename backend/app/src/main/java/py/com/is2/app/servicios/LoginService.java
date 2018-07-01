/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.is2.app.servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import py.com.is2.app.modelos.Roles;
import py.com.is2.app.modelos.Usuarios;

/**
 *
 * @author Kahani
 */
@Stateless
@Path("login")
public class LoginService extends AbstractFacade<Roles> {

    @PersistenceContext(unitName = "py.com.is2_app_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public LoginService() {
        super(Roles.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON})
    public Response validarUsuario(Usuarios entity) {
          Usuarios usuario=null;
        try {
          usuario = (Usuarios) em.createNamedQuery("Usuarios.findByCodigoUsuario")
                    .setParameter("codigoUsuario", entity.getCodigoUsuario())
                    .setParameter("contrasenia", entity.getContrasenia())
                    .getSingleResult();
        } catch (Exception e){
           
        }
         return Response.ok(usuario).build();
    }

    
   @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
