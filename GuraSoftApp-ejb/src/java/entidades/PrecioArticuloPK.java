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
public class PrecioArticuloPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_articulo", nullable = false)
    private long iDarticulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_listaDePrecios", nullable = false)
    private long iDlistaDePrecios;

    public PrecioArticuloPK() {
    }

    public PrecioArticuloPK(long iDarticulo, long iDlistaDePrecios) {
        this.iDarticulo = iDarticulo;
        this.iDlistaDePrecios = iDlistaDePrecios;
    }

    public long getIDarticulo() {
        return iDarticulo;
    }

    public void setIDarticulo(long iDarticulo) {
        this.iDarticulo = iDarticulo;
    }

    public long getIDlistaDePrecios() {
        return iDlistaDePrecios;
    }

    public void setIDlistaDePrecios(long iDlistaDePrecios) {
        this.iDlistaDePrecios = iDlistaDePrecios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDarticulo;
        hash += (int) iDlistaDePrecios;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioArticuloPK)) {
            return false;
        }
        PrecioArticuloPK other = (PrecioArticuloPK) object;
        if (this.iDarticulo != other.iDarticulo) {
            return false;
        }
        if (this.iDlistaDePrecios != other.iDlistaDePrecios) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PrecioArticuloPK[ iDarticulo=" + iDarticulo + ", iDlistaDePrecios=" + iDlistaDePrecios + " ]";
    }
    
}
