/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desap
 */
@Entity
@Table(name = "roles_trazabilidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolesTrazabilidad.findAll", query = "SELECT r FROM RolesTrazabilidad r")
    , @NamedQuery(name = "RolesTrazabilidad.findByIdRolTrazabilidad", query = "SELECT r FROM RolesTrazabilidad r WHERE r.idRolTrazabilidad = :idRolTrazabilidad")
    , @NamedQuery(name = "RolesTrazabilidad.findByTipoRol", query = "SELECT r FROM RolesTrazabilidad r WHERE r.tipoRol = :tipoRol")
    , @NamedQuery(name = "RolesTrazabilidad.findByUsuarioModificacion", query = "SELECT r FROM RolesTrazabilidad r WHERE r.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "RolesTrazabilidad.findByFechaModificacion", query = "SELECT r FROM RolesTrazabilidad r WHERE r.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "RolesTrazabilidad.findByFechaCreacion", query = "SELECT r FROM RolesTrazabilidad r WHERE r.fechaCreacion = :fechaCreacion")})
public class RolesTrazabilidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol_trazabilidad")
    private Integer idRolTrazabilidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo_rol")
    private String tipoRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public RolesTrazabilidad() {
    }

    public RolesTrazabilidad(Integer idRolTrazabilidad) {
        this.idRolTrazabilidad = idRolTrazabilidad;
    }

    public RolesTrazabilidad(Integer idRolTrazabilidad, String tipoRol, String usuarioModificacion, Date fechaModificacion, Date fechaCreacion) {
        this.idRolTrazabilidad = idRolTrazabilidad;
        this.tipoRol = tipoRol;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaModificacion = fechaModificacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdRolTrazabilidad() {
        return idRolTrazabilidad;
    }

    public void setIdRolTrazabilidad(Integer idRolTrazabilidad) {
        this.idRolTrazabilidad = idRolTrazabilidad;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolTrazabilidad != null ? idRolTrazabilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesTrazabilidad)) {
            return false;
        }
        RolesTrazabilidad other = (RolesTrazabilidad) object;
        if ((this.idRolTrazabilidad == null && other.idRolTrazabilidad != null) || (this.idRolTrazabilidad != null && !this.idRolTrazabilidad.equals(other.idRolTrazabilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.RolesTrazabilidad[ idRolTrazabilidad=" + idRolTrazabilidad + " ]";
    }
    
}
