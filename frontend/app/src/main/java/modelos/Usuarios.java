package modelos;

import java.io.Serializable;

public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idUsuario;
    private String codigoUsuario;

    private String nombre;
    private String apellido;
    private String contrasenia;
    private Long idRol;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String codigoUsuario, String nombre, String apellido) {
        this.idUsuario = idUsuario;
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "py.com.is2.app.modelos.Usuarios[ idUsuario=" + idUsuario + " ]";
    }

}
