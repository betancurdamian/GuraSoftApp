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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ariel
 */
@Entity
@Table(name = "stock_articulo", catalog = "gurasoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockArticulo.findAll", query = "SELECT s FROM StockArticulo s"),
    @NamedQuery(name = "StockArticulo.findByIDarticulo", query = "SELECT s FROM StockArticulo s WHERE s.stockArticuloPK.iDarticulo = :iDarticulo"),
    @NamedQuery(name = "StockArticulo.findByIDdeposito", query = "SELECT s FROM StockArticulo s WHERE s.stockArticuloPK.iDdeposito = :iDdeposito"),
    @NamedQuery(name = "StockArticulo.findBySTOCKActual", query = "SELECT s FROM StockArticulo s WHERE s.sTOCKActual = :sTOCKActual"),
    @NamedQuery(name = "StockArticulo.findBySTOCKMaximo", query = "SELECT s FROM StockArticulo s WHERE s.sTOCKMaximo = :sTOCKMaximo"),
    @NamedQuery(name = "StockArticulo.findBySTOCKMinimo", query = "SELECT s FROM StockArticulo s WHERE s.sTOCKMinimo = :sTOCKMinimo")})
public class StockArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StockArticuloPK stockArticuloPK;
    @Column(name = "STOCK_Actual")
    private Integer sTOCKActual;
    @Column(name = "STOCK_Maximo")
    private Integer sTOCKMaximo;
    @Column(name = "STOCK_Minimo")
    private Integer sTOCKMinimo;

    public StockArticulo() {
    }

    public StockArticulo(StockArticuloPK stockArticuloPK) {
        this.stockArticuloPK = stockArticuloPK;
    }

    public StockArticulo(long iDarticulo, long iDdeposito) {
        this.stockArticuloPK = new StockArticuloPK(iDarticulo, iDdeposito);
    }

    public StockArticuloPK getStockArticuloPK() {
        return stockArticuloPK;
    }

    public void setStockArticuloPK(StockArticuloPK stockArticuloPK) {
        this.stockArticuloPK = stockArticuloPK;
    }

    public Integer getSTOCKActual() {
        return sTOCKActual;
    }

    public void setSTOCKActual(Integer sTOCKActual) {
        this.sTOCKActual = sTOCKActual;
    }

    public Integer getSTOCKMaximo() {
        return sTOCKMaximo;
    }

    public void setSTOCKMaximo(Integer sTOCKMaximo) {
        this.sTOCKMaximo = sTOCKMaximo;
    }

    public Integer getSTOCKMinimo() {
        return sTOCKMinimo;
    }

    public void setSTOCKMinimo(Integer sTOCKMinimo) {
        this.sTOCKMinimo = sTOCKMinimo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockArticuloPK != null ? stockArticuloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockArticulo)) {
            return false;
        }
        StockArticulo other = (StockArticulo) object;
        if ((this.stockArticuloPK == null && other.stockArticuloPK != null) || (this.stockArticuloPK != null && !this.stockArticuloPK.equals(other.stockArticuloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.StockArticulo[ stockArticuloPK=" + stockArticuloPK + " ]";
    }
    
}
