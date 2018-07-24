package modelos;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelos.Proyectos;
import modelos.Roles;
import modelos.UserStories;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-11T14:59:37")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile ListAttribute<Usuarios, UserStories> userStoriesList;
    public static volatile SingularAttribute<Usuarios, Roles> idRol;
    public static volatile ListAttribute<Usuarios, Proyectos> proyectosList;
    public static volatile SingularAttribute<Usuarios, String> codigoUsuario;
    public static volatile SingularAttribute<Usuarios, Integer> idUsuario;
    public static volatile SingularAttribute<Usuarios, String> apellido;
    public static volatile SingularAttribute<Usuarios, String> nombre;

}