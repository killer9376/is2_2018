package modelos;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelos.Proyectos;
import modelos.UserStories;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-10T19:10:05")
@StaticMetamodel(Backlog.class)
public class Backlog_ { 

    public static volatile SingularAttribute<Backlog, String> descripcion;
    public static volatile ListAttribute<Backlog, UserStories> userStoriesList;
    public static volatile SingularAttribute<Backlog, String> tituloBacklog;
    public static volatile SingularAttribute<Backlog, Proyectos> idProyecto;
    public static volatile SingularAttribute<Backlog, Integer> idBacklog;

}