package com.fpuna.is2.agile.modelos;

public class Proyecto{
        private Integer idProyecto;
        private String nombreProyecto;
        private String descripcion;
        private String fechaInicio;
        private String anio;
        private String estado;

    private Usuario adminProyecto;

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getAdminProyecto() {
        return adminProyecto;
    }

    public void setAdminProyecto(Usuario adminProyecto) {
        this.adminProyecto = adminProyecto;
    }
}
