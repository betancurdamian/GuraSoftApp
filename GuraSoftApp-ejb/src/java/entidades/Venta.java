/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ariel
 */
@Entity
@Table(name = "venta", catalog = "gurasoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findById", query = "SELECT v FROM Venta v WHERE v.id = :id"),
    @NamedQuery(name = "Venta.findByEsCompleta", query = "SELECT v FROM Venta v WHERE v.esCompleta = :esCompleta"),
    @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Venta.findByHora", query = "SELECT v FROM Venta v WHERE v.hora = :hora")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "ES_COMPLETA")
    private Boolean esCompleta;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona clienteId;
    @JoinColumn(name = "EMPLEADO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona empleadoId;
    @JoinColumn(name = "PAGO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pago pagoId;
    @JoinColumn(name = "UNIDAD_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Unidad unidadId;
    @OneToMany(mappedBy = "ventaId", fetch = FetchType.LAZY)
    private List<Comprobante> comprobanteList;
    @OneToMany(mappedBy = "ventaId", fetch = FetchType.LAZY)
    private List<LineaVenta> lineaVentaList;

    public Venta() {
    }

    public Venta(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEsCompleta() {
        return esCompleta;
    }

    public void setEsCompleta(Boolean esCompleta) {
        this.esCompleta = esCompleta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Persona getClienteId() {
        return clienteId;
    }

    public void setClienteId(Persona clienteId) {
        this.clienteId = clienteId;
    }

    public Persona getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Persona empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Pago getPagoId() {
        return pagoId;
    }

    public void setPagoId(Pago pagoId) {
        this.pagoId = pagoId;
    }

    public Unidad getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(Unidad unidadId) {
        this.unidadId = unidadId;
    }

    @XmlTransient
    public List<Comprobante> getComprobanteList() {
        return comprobanteList;
    }

    public void setComprobanteList(List<Comprobante> comprobanteList) {
        this.comprobanteList = comprobanteList;
    }

    @XmlTransient
    public List<LineaVenta> getLineaVentaList() {
        return lineaVentaList;
    }

    public void setLineaVentaList(List<LineaVenta> lineaVentaList) {
        this.lineaVentaList = lineaVentaList;
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
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Venta[ id=" + id + " ]";
    }
    
}
