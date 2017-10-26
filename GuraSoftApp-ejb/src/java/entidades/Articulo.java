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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "articulo", catalog = "gurasoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByIdArticulo", query = "SELECT a FROM Articulo a WHERE a.idArticulo = :idArticulo"),
    @NamedQuery(name = "Articulo.findByDescripcion", query = "SELECT a FROM Articulo a WHERE a.descripcion = :descripcion")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articulo", nullable = false)
    private Long idArticulo;
    @Size(max = 255)
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @OneToMany(mappedBy = "aRTICULOidarticulo", fetch = FetchType.LAZY)
    private List<LineaVenta> lineaVentaList;
    @JoinColumn(name = "UNCATEGORIADECATALOGO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoriaCatalogo uncategoriadecatalogoId;
    @JoinColumn(name = "UNPROVEEDOR_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona unproveedorId;

    public Articulo() {
    }

    public Articulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<LineaVenta> getLineaVentaList() {
        return lineaVentaList;
    }

    public void setLineaVentaList(List<LineaVenta> lineaVentaList) {
        this.lineaVentaList = lineaVentaList;
    }

    public CategoriaCatalogo getUncategoriadecatalogoId() {
        return uncategoriadecatalogoId;
    }

    public void setUncategoriadecatalogoId(CategoriaCatalogo uncategoriadecatalogoId) {
        this.uncategoriadecatalogoId = uncategoriadecatalogoId;
    }

    public Persona getUnproveedorId() {
        return unproveedorId;
    }

    public void setUnproveedorId(Persona unproveedorId) {
        this.unproveedorId = unproveedorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Articulo[ idArticulo=" + idArticulo + " ]";
    }
    
}
