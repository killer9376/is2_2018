/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desap
 */
@Entity
@Table(name = "backlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Backlog.findAll", query = "SELECT b FROM Backlog b")
    , @NamedQuery(name = "Backlog.findByIdBacklog", query = "SELECT b FROM Backlog b WHERE b.idBacklog = :idBacklog")
    , @NamedQuery(name = "Backlog.findByTituloBacklog", query = "SELECT b FROM Backlog b WHERE b.tituloBacklog = :tituloBacklog")
    , @NamedQuery(name = "Backlog.findByDescripcion", query = "SELECT b FROM Backlog b WHERE b.descripcion = :descripcion")})
public class Backlog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_backlog")
    private Integer idBacklog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "titulo_backlog")
    private String tituloBacklog;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "backlog_us", joinColumns = {
        @JoinColumn(name = "id_backlog", referencedColumnName = "id_backlog")}, inverseJoinColumns = {
        @JoinColumn(name = "id_user_story", referencedColumnName = "id_user_story")})
    @ManyToMany
    private List<UserStories> userStoriesList;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyectos idProyecto;

    public Backlog() {
    }

    public Backlog(Integer idBacklog) {
        this.idBacklog = idBacklog;
    }

    public Backlog(Integer idBacklog, String tituloBacklog) {
        this.idBacklog = idBacklog;
        this.tituloBacklog = tituloBacklog;
    }

    public Integer getIdBacklog() {
        return idBacklog;
    }

    public void setIdBacklog(Integer idBacklog) {
        this.idBacklog = idBacklog;
    }

    public String getTituloBacklog() {
        return tituloBacklog;
    }

    public void setTituloBacklog(String tituloBacklog) {
        this.tituloBacklog = tituloBacklog;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<UserStories> getUserStoriesList() {
        return userStoriesList;
    }

    public void setUserStoriesList(List<UserStories> userStoriesList) {
        this.userStoriesList = userStoriesList;
    }

    public Proyectos getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyectos idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBacklog != null ? idBacklog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Backlog)) {
            return false;
        }
        Backlog other = (Backlog) object;
        if ((this.idBacklog == null && other.idBacklog != null) || (this.idBacklog != null && !this.idBacklog.equals(other.idBacklog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Backlog[ idBacklog=" + idBacklog + " ]";
    }
    
}
