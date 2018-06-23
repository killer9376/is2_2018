/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.is2.app.servicios;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Kahani
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(py.com.is2.app.servicios.BacklogFacadeREST.class);
        resources.add(py.com.is2.app.servicios.LoginService.class);
        resources.add(py.com.is2.app.servicios.ProyectosFacadeREST.class);
        resources.add(py.com.is2.app.servicios.RolesFacadeREST.class);
        resources.add(py.com.is2.app.servicios.RolesTrazabilidadFacadeREST.class);
        resources.add(py.com.is2.app.servicios.SprintsFacadeREST.class);
        resources.add(py.com.is2.app.servicios.UserStoriesFacadeREST.class);
        resources.add(py.com.is2.app.servicios.UsuariosFacadeREST.class);
    }
    
}
