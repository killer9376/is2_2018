package modelos;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelos.Backlog;
import modelos.Sprints;
import modelos.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-11T14:59:37")
@StaticMetamodel(UserStories.class)
public class UserStories_ { 

    public static volatile SingularAttribute<UserStories, String> descripcion;
    public static volatile ListAttribute<UserStories, Usuarios> usuariosList;
    public static volatile ListAttribute<UserStories, Backlog> backlogList;
    public static volatile SingularAttribute<UserStories, String> titulo;
    public static volatile SingularAttribute<UserStories, Sprints> idSprint;
    public static volatile SingularAttribute<UserStories, Integer> idUserStory;
    public static volatile SingularAttribute<UserStories, Integer> prioridad;

}