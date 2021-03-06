/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ariel
 */
@Entity
@Table(name = "deposito", catalog = "gurasoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deposito.findAll", query = "SELECT d FROM Deposito d"),
    @NamedQuery(name = "Deposito.findByIdDeposito", query = "SELECT d FROM Deposito d WHERE d.idDeposito = :idDeposito"),
    @NamedQuery(name = "Deposito.findByDescripcion", query = "SELECT d FROM Deposito d WHERE d.descripcion = :descripcion")})
public class Deposito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_deposito", nullable = false)
    private Long idDeposito;
    @Size(max = 255)
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @JoinColumn(name = "UNAUNIDAD_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Unidad unaunidadId;

    public Deposito() {
    }

    public Deposito(Long idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Long getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Long idDeposito) {
        this.idDeposito = idDeposito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Unidad getUnaunidadId() {
        return unaunidadId;
    }

    public void setUnaunidadId(Unidad unaunidadId) {
        this.unaunidadId = unaunidadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeposito != null ? idDeposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deposito)) {
            return false;
        }
        Deposito other = (Deposito) object;
        if ((this.idDeposito == null && other.idDeposito != null) || (this.idDeposito != null && !this.idDeposito.equals(other.idDeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Deposito[ idDeposito=" + idDeposito + " ]";
    }
    
}
