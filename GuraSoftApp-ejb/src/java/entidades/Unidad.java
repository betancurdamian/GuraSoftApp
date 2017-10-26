/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ariel
 */
@Entity
@Table(name = "unidad", catalog = "gurasoft", schema = "")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"),
    @NamedQuery(name = "Unidad.findById", query = "SELECT u FROM Unidad u WHERE u.id = :id"),
    @NamedQuery(name = "Unidad.findByNombre", query = "SELECT u FROM Unidad u WHERE u.nombre = :nombre")})
public abstract class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Long id;        
    
    @Size(max = 255)
    @Column(name = "nombre", length = 255)
    private String nombre;
    
    @JoinTable(name = "unidad_persona", joinColumns = {
        @JoinColumn(name = "Unidad_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "empleados_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Persona> personaList;
    
    @OneToMany(mappedBy = "unidadId", fetch = FetchType.LAZY)
    private List<Venta> ventaList;
    
    @OneToMany(mappedBy = "unidadId", fetch = FetchType.LAZY)
    private List<Persona> personaList1;
    
    @OneToMany(mappedBy = "unaunidadId", fetch = FetchType.LAZY)
    private List<Deposito> depositoList;
    
    @JoinColumn(name = "UNAEMPRESA_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa unaempresaId;
    
    @OneToMany(mappedBy = "unidadId", fetch = FetchType.LAZY)
    private List<TipoEmpleado> tipoEmpleadoList;

    public Unidad() {
    }

    public Unidad(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<Persona> getPersonaList1() {
        return personaList1;
    }

    public void setPersonaList1(List<Persona> personaList1) {
        this.personaList1 = personaList1;
    }

    @XmlTransient
    public List<Deposito> getDepositoList() {
        return depositoList;
    }

    public void setDepositoList(List<Deposito> depositoList) {
        this.depositoList = depositoList;
    }

    public Empresa getUnaempresaId() {
        return unaempresaId;
    }

    public void setUnaempresaId(Empresa unaempresaId) {
        this.unaempresaId = unaempresaId;
    }

    @XmlTransient
    public List<TipoEmpleado> getTipoEmpleadoList() {
        return tipoEmpleadoList;
    }

    public void setTipoEmpleadoList(List<TipoEmpleado> tipoEmpleadoList) {
        this.tipoEmpleadoList = tipoEmpleadoList;
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
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Unidad[ id=" + id + " ]";
    }
    
}
