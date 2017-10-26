/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Ariel
 */
@Entity
@Table(name = "comprobante", catalog = "gurasoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprobante.findAll", query = "SELECT c FROM Comprobante c"),
    @NamedQuery(name = "Comprobante.findById", query = "SELECT c FROM Comprobante c WHERE c.id = :id"),
    @NamedQuery(name = "Comprobante.findByType", query = "SELECT c FROM Comprobante c WHERE c.type = :type"),
    @NamedQuery(name = "Comprobante.findByDescuento", query = "SELECT c FROM Comprobante c WHERE c.descuento = :descuento"),
    @NamedQuery(name = "Comprobante.findByFecha", query = "SELECT c FROM Comprobante c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Comprobante.findByIva", query = "SELECT c FROM Comprobante c WHERE c.iva = :iva"),
    @NamedQuery(name = "Comprobante.findByNumerocomprobante", query = "SELECT c FROM Comprobante c WHERE c.numerocomprobante = :numerocomprobante"),
    @NamedQuery(name = "Comprobante.findBySubtotal", query = "SELECT c FROM Comprobante c WHERE c.subtotal = :subtotal"),
    @NamedQuery(name = "Comprobante.findByTotal", query = "SELECT c FROM Comprobante c WHERE c.total = :total")})
public class Comprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Long id;
    @Size(max = 20)
    @Column(name = "type", length = 20)
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DESCUENTO", precision = 12)
    private Float descuento;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "IVA", precision = 12)
    private Float iva;
    @Column(name = "NUMEROCOMPROBANTE")
    private Integer numerocomprobante;
    @Column(name = "SUBTOTAL", precision = 12)
    private Float subtotal;
    @Column(name = "TOTAL", precision = 12)
    private Float total;
    @JoinColumn(name = "VENTA_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Venta ventaId;

    public Comprobante() {
    }

    public Comprobante(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Integer getNumerocomprobante() {
        return numerocomprobante;
    }

    public void setNumerocomprobante(Integer numerocomprobante) {
        this.numerocomprobante = numerocomprobante;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Venta getVentaId() {
        return ventaId;
    }

    public void setVentaId(Venta ventaId) {
        this.ventaId = ventaId;
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
        if (!(object instanceof Comprobante)) {
            return false;
        }
        Comprobante other = (Comprobante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Comprobante[ id=" + id + " ]";
    }
    
}
