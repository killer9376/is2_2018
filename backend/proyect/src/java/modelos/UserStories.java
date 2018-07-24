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
@Table(name = "user_stories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserStories.findAll", query = "SELECT u FROM UserStories u")
    , @NamedQuery(name = "UserStories.findByIdUserStory", query = "SELECT u FROM UserStories u WHERE u.idUserStory = :idUserStory")
    , @NamedQuery(name = "UserStories.findByPrioridad", query = "SELECT u FROM UserStories u WHERE u.prioridad = :prioridad")
    , @NamedQuery(name = "UserStories.findByTitulo", query = "SELECT u FROM UserStories u WHERE u.titulo = :titulo")
    , @NamedQuery(name = "UserStories.findByDescripcion", query = "SELECT u FROM UserStories u WHERE u.descripcion = :descripcion")})
public class UserStories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user_story")
    private Integer idUserStory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prioridad")
    private int prioridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "userStoriesList")
    private List<Backlog> backlogList;
    @JoinTable(name = "usuarios_us", joinColumns = {
        @JoinColumn(name = "id_user_story", referencedColumnName = "id_user_story")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "id_sprint", referencedColumnName = "id_sprint")
    @ManyToOne(optional = false)
    private Sprints idSprint;

    public UserStories() {
    }

    public UserStories(Integer idUserStory) {
        this.idUserStory = idUserStory;
    }

    public UserStories(Integer idUserStory, int prioridad, String titulo, String descripcion) {
        this.idUserStory = idUserStory;
        this.prioridad = prioridad;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

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

    @XmlTransient
    public List<Backlog> getBacklogList() {
        return backlogList;
    }

    public void setBacklogList(List<Backlog> backlogList) {
        this.backlogList = backlogList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Sprints getIdSprint() {
        return idSprint;
    }

    public void setIdSprint(Sprints idSprint) {
        this.idSprint = idSprint;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserStory != null ? idUserStory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserStories)) {
            return false;
        }
        UserStories other = (UserStories) object;
        if ((this.idUserStory == null && other.idUserStory != null) || (this.idUserStory != null && !this.idUserStory.equals(other.idUserStory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.UserStories[ idUserStory=" + idUserStory + " ]";
    }
    
}
