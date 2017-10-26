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
public class StockArticuloPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_articulo", nullable = false)
    private long iDarticulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_deposito", nullable = false)
    private long iDdeposito;

    public StockArticuloPK() {
    }

    public StockArticuloPK(long iDarticulo, long iDdeposito) {
        this.iDarticulo = iDarticulo;
        this.iDdeposito = iDdeposito;
    }

    public long getIDarticulo() {
        return iDarticulo;
    }

    public void setIDarticulo(long iDarticulo) {
        this.iDarticulo = iDarticulo;
    }

    public long getIDdeposito() {
        return iDdeposito;
    }

    public void setIDdeposito(long iDdeposito) {
        this.iDdeposito = iDdeposito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDarticulo;
        hash += (int) iDdeposito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockArticuloPK)) {
            return false;
        }
        StockArticuloPK other = (StockArticuloPK) object;
        if (this.iDarticulo != other.iDarticulo) {
            return false;
        }
        if (this.iDdeposito != other.iDdeposito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.StockArticuloPK[ iDarticulo=" + iDarticulo + ", iDdeposito=" + iDdeposito + " ]";
    }
    
}
