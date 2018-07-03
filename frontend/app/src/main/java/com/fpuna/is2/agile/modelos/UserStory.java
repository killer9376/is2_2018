package com.fpuna.is2.agile.modelos;

public class UserStory {
    private Integer idUserStory;
    private int prioridad;
    private String titulo;
    private String descripcion;

    public Integer getIdUserStory() {
        return idUserStory;
    }

    public void setIdUserStory(Integer idUserStory) {
        this.idUserStory = idUserStory;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
