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
@Table(name = "categoria_catalogo", catalog = "gurasoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaCatalogo.findAll", query = "SELECT c FROM CategoriaCatalogo c"),
    @NamedQuery(name = "CategoriaCatalogo.findById", query = "SELECT c FROM CategoriaCatalogo c WHERE c.id = :id"),
    @NamedQuery(name = "CategoriaCatalogo.findByDescripcion", query = "SELECT c FROM CategoriaCatalogo c WHERE c.descripcion = :descripcion")})
public class CategoriaCatalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @JoinColumn(name = "UNCATALOGO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CatalogoArticulo uncatalogoId;
    @OneToMany(mappedBy = "uncategoriadecatalogoId", fetch = FetchType.LAZY)
    private List<Articulo> articuloList;

    public CategoriaCatalogo() {
    }

    public CategoriaCatalogo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CatalogoArticulo getUncatalogoId() {
        return uncatalogoId;
    }

    public void setUncatalogoId(CatalogoArticulo uncatalogoId) {
        this.uncatalogoId = uncatalogoId;
    }

    @XmlTransient
    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
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
        if (!(object instanceof CategoriaCatalogo)) {
            return false;
        }
        CategoriaCatalogo other = (CategoriaCatalogo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CategoriaCatalogo[ id=" + id + " ]";
    }
    
}
