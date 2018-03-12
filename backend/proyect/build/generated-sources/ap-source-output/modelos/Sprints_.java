package modelos;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelos.Proyectos;
import modelos.UserStories;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-11T14:59:37")
@StaticMetamodel(Sprints.class)
public class Sprints_ { 

    public static volatile SingularAttribute<Sprints, String> descripcion;
    public static volatile ListAttribute<Sprints, UserStories> userStoriesList;
    public static volatile SingularAttribute<Sprints, Proyectos> idProyecto;
    public static volatile SingularAttribute<Sprints, Date> fechaInicio;
    public static volatile SingularAttribute<Sprints, Integer> idSprint;
    public static volatile SingularAttribute<Sprints, String> titulo;
    public static volatile SingularAttribute<Sprints, Integer> duracion;
    public static volatile SingularAttribute<Sprints, String> fechaFin;

}