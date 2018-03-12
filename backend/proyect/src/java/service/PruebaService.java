/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import modelos.Roles;

/**
 * @author desap
 */
@Stateless
@Path("consulta")
public class PruebaService {
  @PersistenceContext(unitName = "proyectPU")
    private EntityManager em;
   
   @POST
    public void conuslta(){
    String  qlString ="select * from roles ";
        Query query = em.createNativeQuery(qlString, Roles.class);
      List<Roles> rol = query.getResultList();
        for (Roles object : rol) {
            System.out.println(object.toString());
       }
        
    }
    
}
