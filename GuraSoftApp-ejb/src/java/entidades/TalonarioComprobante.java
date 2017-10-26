/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ariel
 */
@Entity
@Table(name = "talonario_comprobante", catalog = "gurasoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TalonarioComprobante.findAll", query = "SELECT t FROM TalonarioComprobante t"),
    @NamedQuery(name = "TalonarioComprobante.findByIDTipoCliente", query = "SELECT t FROM TalonarioComprobante t WHERE t.talonarioComprobantePK.iDTipoCliente = :iDTipoCliente"),
    @NamedQuery(name = "TalonarioComprobante.findByIDUnidad", query = "SELECT t FROM TalonarioComprobante t WHERE t.talonarioComprobantePK.iDUnidad = :iDUnidad"),
    @NamedQuery(name = "TalonarioComprobante.findByDescripcion", query = "SELECT t FROM TalonarioComprobante t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TalonarioComprobante.findByNumeracionActual", query = "SELECT t FROM TalonarioComprobante t WHERE t.numeracionActual = :numeracionActual"),
    @NamedQuery(name = "TalonarioComprobante.findByNumeracionDesde", query = "SELECT t FROM TalonarioComprobante t WHERE t.numeracionDesde = :numeracionDesde"),
    @NamedQuery(name = "TalonarioComprobante.findByNumeracionHasta", query = "SELECT t FROM TalonarioComprobante t WHERE t.numeracionHasta = :numeracionHasta")})
public class TalonarioComprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TalonarioComprobantePK talonarioComprobantePK;
    @Size(max = 255)
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @Column(name = "numeracion_Actual")
    private Integer numeracionActual;
    @Column(name = "numeracion_Desde")
    private Integer numeracionDesde;
    @Column(name = "numeracion_Hasta")
    private Integer numeracionHasta;

    public TalonarioComprobante() {
    }

    public TalonarioComprobante(TalonarioComprobantePK talonarioComprobantePK) {
        this.talonarioComprobantePK = talonarioComprobantePK;
    }

    public TalonarioComprobante(long iDTipoCliente, long iDUnidad) {
        this.talonarioComprobantePK = new TalonarioComprobantePK(iDTipoCliente, iDUnidad);
    }

    public TalonarioComprobantePK getTalonarioComprobantePK() {
        return talonarioComprobantePK;
    }

    public void setTalonarioComprobantePK(TalonarioComprobantePK talonarioComprobantePK) {
        this.talonarioComprobantePK = talonarioComprobantePK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumeracionActual() {
        return numeracionActual;
    }

    public void setNumeracionActual(Integer numeracionActual) {
        this.numeracionActual = numeracionActual;
    }

    public Integer getNumeracionDesde() {
        return numeracionDesde;
    }

    public void setNumeracionDesde(Integer numeracionDesde) {
        this.numeracionDesde = numeracionDesde;
    }

    public Integer getNumeracionHasta() {
        return numeracionHasta;
    }

    public void setNumeracionHasta(Integer numeracionHasta) {
        this.numeracionHasta = numeracionHasta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (talonarioComprobantePK != null ? talonarioComprobantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TalonarioComprobante)) {
            return false;
        }
        TalonarioComprobante other = (TalonarioComprobante) object;
        if ((this.talonarioComprobantePK == null && other.talonarioComprobantePK != null) || (this.talonarioComprobantePK != null && !this.talonarioComprobantePK.equals(other.talonarioComprobantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TalonarioComprobante[ talonarioComprobantePK=" + talonarioComprobantePK + " ]";
    }
    
}
