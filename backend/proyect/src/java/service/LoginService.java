/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
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
@Path("login")
public class LoginService {
  @PersistenceContext(unitName = "proyectPU")
    private EntityManager em;
   
   @POST
    public boolean conuslta(Usuarios usuario){
        boolean logueado= false;
        String  qlString ="select * from usuario where codigoUsuaio= \'" + usuario.getCodigoUsuario() + "\' and contrasenia = \'" + usuario.getContrasenia()+"\'";
        Query query = em.createNativeQuery(qlString, Usuarios.class);
        List usuarioLog = query.getResultList();
        if(usuarioLog.size()>0){
            System.out.println("Logeado");
             logueado= true;
        }else{
            System.out.println("No logeado");
             logueado= false;
        }
       return  logueado;
    }
    
}
