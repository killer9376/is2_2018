/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import modelos.Usuarios;

/**
 * @author desap
 */
@Stateless
@Path("consulta")
public class PruebaService {
  @PersistenceContext(unitName = "proyectPU")
    private EntityManager em;
   
   @POST
    public void conuslta(Usuarios usuario){
        String  qlString ="select * from usuario where codigoUsuaio= " + usuario.getCodigoUsuario() + " and contrasenia = " + usuario.getContrasenia();
        Query query = em.createNativeQuery(qlString, Usuarios.class);
        int usuarioLog = query.getMaxResults();
        if(usuarioLog>0){
            System.out.println("Logeado");
        }else{
            System.out.println("No logeado");
        }
       
    }
    
}
