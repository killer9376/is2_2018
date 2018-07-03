package com.fpuna.is2.agile.modelos;

public class Sprint {
    private Integer idSprint;

    private String titulo;

    private String fechaInicio;

    private Integer duracion;

    private String descripcion;

    private String fechaFin;

    private Proyecto idProyecto;

    private Usuario idUsuario;

    private UserStory idUserStory;

    public UserStory getIdUserStory() {
        return idUserStory;
    }

    public void setIdUserStory(UserStory idUserStory) {
        this.idUserStory = idUserStory;
    }

    public Integer getIdSprint() {
        return idSprint;
    }

    public void setIdSprint(Integer idSprint) {
        this.idSprint = idSprint;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return  "Titulo: "+getTitulo() + " \nProyecto: "+ getIdProyecto().getNombreProyecto() + " \nEstado"+getIdUserStory().getDescripcion()+"\n";
    }
}
