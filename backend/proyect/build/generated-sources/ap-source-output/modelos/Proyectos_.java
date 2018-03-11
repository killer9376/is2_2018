package modelos;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelos.Backlog;
import modelos.Sprints;
import modelos.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-10T19:10:05")
@StaticMetamodel(Proyectos.class)
public class Proyectos_ { 

    public static volatile SingularAttribute<Proyectos, String> descripcion;
    public static volatile SingularAttribute<Proyectos, Integer> idProyecto;
    public static volatile SingularAttribute<Proyectos, String> estado;
    public static volatile ListAttribute<Proyectos, Backlog> backlogList;
    public static volatile SingularAttribute<Proyectos, String> fechaInicio;
    public static volatile SingularAttribute<Proyectos, String> nombreProyecto;
    public static volatile SingularAttribute<Proyectos, Usuarios> adminProyecto;
    public static volatile ListAttribute<Proyectos, Sprints> sprintsList;
    public static volatile SingularAttribute<Proyectos, String> anio;

}