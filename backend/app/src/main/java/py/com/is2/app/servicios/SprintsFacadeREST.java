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
import py.com.is2.app.modelos.Proyectos;
import py.com.is2.app.modelos.Sprints;
import py.com.is2.app.modelos.Usuarios;

/**
 *
 * @author Kahani
 */
@Stateless
@Path("sprints")
public class SprintsFacadeREST extends AbstractFacade<Sprints> {

    @PersistenceContext(unitName = "py.com.is2_app_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public SprintsFacadeREST() {
        super(Sprints.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sprints entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Sprints entity) {
        Sprints tarea = find(id);
//         bundle.putString("nombreTarea",tareaSeleccionada.getTitulo());
//                    bundle.putInt("idProyecto",tareaSeleccionada.getIdProyecto().getIdProyecto());
//                    bundle.putString("descripcion",tareaSeleccionada.getDescripcion());
//                    bundle.putString("fechaInicio",tareaSeleccionada.getFechaInicio());
//                    bundle.putString("fechaFin",tareaSeleccionada.getFechaFin());
//                      bundle.putInt("duracion",tareaSeleccionada.getDuracion());
        tarea.setTitulo(entity.getTitulo());
        super.edit(entity);
    }

    @POST
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sprints find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprints> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("tareas/{idUsuario}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Sprints> obtenerTareas(@PathParam("idUsuario") Integer id) {
        List<Sprints> lista = new ArrayList<>();
        try {
            Usuarios user = new Usuarios();
            user.setIdUsuario(id);
              lista = (List<Sprints>) em.createNamedQuery("Sprints.findByIdUser")
                    .setParameter("idUsuario",user)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
        return lista;
    }
    
    @GET
    @Path("/obtener/{filtro}/{idUsuario}")
    @Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,})
    public List<Sprints> encontrarTareas(@PathParam("filtro") String filtro, @PathParam("idUsuario") Integer idUsuario) {
        List<Sprints> lista = new ArrayList<>();
     
         try {
             Usuarios user = new Usuarios();
             user.setIdUsuario(idUsuario);
          Query q = em.createNamedQuery("Sprints.findByIdUserMod")
                    .setParameter("idUsuario", user)
                    .setParameter("filtro","%"+filtro.toUpperCase()+"%");       
         lista   = (List<Sprints>) q.getResultList();

        } catch (Exception e){
             System.out.println(e.getMessage());
        }
        
        return lista;
    }
    
    @GET
    @Path("pendientes/{idUsuario}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Sprints> obtenerTareasPendientes(@PathParam("idUsuario") Integer id) {
        List<Sprints> lista = new ArrayList<>();
        try {
            Usuarios user = new Usuarios();
            user.setIdUsuario(id);
              lista = (List<Sprints>) em.createNamedQuery("Sprints.findByIdUser")
                    .setParameter("idUsuario",user)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
        return lista;
    }
    
     
    @GET
    @Path("proyectos/{idUsuario}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Proyectos> obtenerProyectos(@PathParam("idUsuario") Integer id) {
        List<Proyectos> listaProyectos = new ArrayList<>();
        List<Sprints> lista = new ArrayList<>();
        try {
            Usuarios user = new Usuarios();
            user.setIdUsuario(id);
              lista = (List<Sprints>) em.createNamedQuery("Sprints.findByIdUser")
                    .setParameter("idUsuario",user)
                    .getResultList();
              
              for (Sprints item: lista) {
                 Proyectos p = item.getIdProyecto();
                 if(!listaProyectos.contains(p)){
                        listaProyectos.add(p);
                 }
              }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
        return listaProyectos;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprints> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
