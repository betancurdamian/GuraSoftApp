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
@Table(name = "precio_articulo", catalog = "gurasoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrecioArticulo.findAll", query = "SELECT p FROM PrecioArticulo p"),
    @NamedQuery(name = "PrecioArticulo.findByIDarticulo", query = "SELECT p FROM PrecioArticulo p WHERE p.precioArticuloPK.iDarticulo = :iDarticulo"),
    @NamedQuery(name = "PrecioArticulo.findByIDlistaDePrecios", query = "SELECT p FROM PrecioArticulo p WHERE p.precioArticuloPK.iDlistaDePrecios = :iDlistaDePrecios"),
    @NamedQuery(name = "PrecioArticulo.findByPrecio", query = "SELECT p FROM PrecioArticulo p WHERE p.precio = :precio")})
public class PrecioArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrecioArticuloPK precioArticuloPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO", precision = 12)
    private Float precio;

    public PrecioArticulo() {
    }

    public PrecioArticulo(PrecioArticuloPK precioArticuloPK) {
        this.precioArticuloPK = precioArticuloPK;
    }

    public PrecioArticulo(long iDarticulo, long iDlistaDePrecios) {
        this.precioArticuloPK = new PrecioArticuloPK(iDarticulo, iDlistaDePrecios);
    }

    public PrecioArticuloPK getPrecioArticuloPK() {
        return precioArticuloPK;
    }

    public void setPrecioArticuloPK(PrecioArticuloPK precioArticuloPK) {
        this.precioArticuloPK = precioArticuloPK;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (precioArticuloPK != null ? precioArticuloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioArticulo)) {
            return false;
        }
        PrecioArticulo other = (PrecioArticulo) object;
        if ((this.precioArticuloPK == null && other.precioArticuloPK != null) || (this.precioArticuloPK != null && !this.precioArticuloPK.equals(other.precioArticuloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PrecioArticulo[ precioArticuloPK=" + precioArticuloPK + " ]";
    }
    
}
