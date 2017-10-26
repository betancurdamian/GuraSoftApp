/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ariel
 */
@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = STRING, length = 20)
@DiscriminatorValue("PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT p FROM Persona p WHERE p.id = :id"),
    @NamedQuery(name = "Cliente.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByCuitCuil", query = "SELECT p FROM Persona p WHERE p.cuitCuil = :cuitCuil"),
    @NamedQuery(name = "Cliente.findByFechaIngreso", query = "SELECT p FROM Persona p WHERE p.fechaIngreso = :fechaIngreso")})
public abstract class Persona implements Serializable {

    protected static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    protected Long id;
        
    @Size(max = 255)
    @Column(name = "nombre", length = 255)
    protected String nombre;
    
    @Size(max = 255)
    @Column(name = "apellido", length = 255)
    protected String apellido;
        
    @ManyToMany(mappedBy = "personaList", fetch = FetchType.LAZY)
    protected List<Unidad> unidadList;
        
    @JoinColumn(name = "DIRECCION_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    protected Direccion direccionId;
    
    @JoinColumn(name = "UNAEMPRESA_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    protected Empresa unaempresaId;
    
    @JoinColumn(name = "UNIDAD_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    protected Unidad unidadId;
    
    @Size(max = 255)
    @Column(name = "cuitCuil", length = 255)
    protected String cuitCuil;

    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    protected Date fechaIngreso;
    
    public Persona() {
    }

    public Persona(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @XmlTransient
    public List<Unidad> getUnidadList() {
        return unidadList;
    }

    public void setUnidadList(List<Unidad> unidadList) {
        this.unidadList = unidadList;
    }

    public Direccion getDireccionId() {
        return direccionId;
    }

    public void setDireccionId(Direccion direccionId) {
        this.direccionId = direccionId;
    }

    public Empresa getUnaempresaId() {
        return unaempresaId;
    }

    public void setUnaempresaId(Empresa unaempresaId) {
        this.unaempresaId = unaempresaId;
    }

    public Unidad getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(Unidad unidadId) {
        this.unidadId = unidadId;
    }
    
    public String getCuitCuil() {
        return cuitCuil;
    }

    public void setCuitCuil(String cuitCuil) {
        this.cuitCuil = cuitCuil;
    }
    
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Persona[ id=" + id + " ]";
    }
    
}
