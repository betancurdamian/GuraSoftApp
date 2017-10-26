/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ariel
 */
@Embeddable
public class TalonarioComprobantePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TipoCliente", nullable = false)
    private long iDTipoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Unidad", nullable = false)
    private long iDUnidad;

    public TalonarioComprobantePK() {
    }

    public TalonarioComprobantePK(long iDTipoCliente, long iDUnidad) {
        this.iDTipoCliente = iDTipoCliente;
        this.iDUnidad = iDUnidad;
    }

    public long getIDTipoCliente() {
        return iDTipoCliente;
    }

    public void setIDTipoCliente(long iDTipoCliente) {
        this.iDTipoCliente = iDTipoCliente;
    }

    public long getIDUnidad() {
        return iDUnidad;
    }

    public void setIDUnidad(long iDUnidad) {
        this.iDUnidad = iDUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDTipoCliente;
        hash += (int) iDUnidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TalonarioComprobantePK)) {
            return false;
        }
        TalonarioComprobantePK other = (TalonarioComprobantePK) object;
        if (this.iDTipoCliente != other.iDTipoCliente) {
            return false;
        }
        if (this.iDUnidad != other.iDUnidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TalonarioComprobantePK[ iDTipoCliente=" + iDTipoCliente + ", iDUnidad=" + iDUnidad + " ]";
    }
    
}
