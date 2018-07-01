package com.fpuna.is2.agile.modelos;

import java.io.Serializable;

public class Usuario {

    private Integer idUsuario;
    private String codigoUsuario;

    private String nombre;
    private String apellido;
    private String contrasenia;
   // private List<UserStories> userStoriesList;
   // private List<Proyectos> proyectosList;
    private Rol idRol;

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

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @Override
    public String toString() {
        return "Codigo: "+getCodigoUsuario() + " \nNombre: "+ getNombre() + " "+getApellido() ;
    }
}
