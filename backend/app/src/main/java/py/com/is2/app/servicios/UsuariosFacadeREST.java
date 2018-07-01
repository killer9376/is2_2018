/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.is2.app.servicios;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import py.com.is2.app.modelos.Usuarios;

/**
 *
 * @author Kahani
 */
@Stateless
@Path("usuarios")
public class UsuariosFacadeREST extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "py.com.is2_app_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public UsuariosFacadeREST() {
        super(Usuarios.class);
    }

    @POST
    @Override
    @Consumes({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON})
    public void create(Usuarios entity) {
            super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuarios entity) {
        Usuarios user = super.find(id);
        user.setNombre(entity.getNombre());
        user.setApellido(entity.getApellido());
        user.setIdRol( entity.getIdRol() );
        super.edit(user);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuarios find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,})
    public List<Usuarios> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("/obtener/{codigoUsuario}")
    @Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,})
    public List<Usuarios> encontrarUsuarios(@PathParam("codigoUsuario") String codigoUsuario) {
        List<Usuarios> listaUsuarios = new ArrayList<>();
                     System.out.println(codigoUsuario);
         try {
          Query q = em.createNamedQuery("Usuarios.findByCodigo")
                    .setParameter("codigoUsuario","%"+codigoUsuario.toUpperCase()+"%");       
        listaUsuarios = (List<Usuarios>) q.getResultList();

        } catch (Exception e){
             System.out.println(e.getMessage());
        }
        
        return listaUsuarios;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuarios> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
