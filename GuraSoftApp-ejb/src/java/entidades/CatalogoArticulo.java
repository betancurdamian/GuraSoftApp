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
@Table(name = "catalogo_articulo", catalog = "gurasoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoArticulo.findAll", query = "SELECT c FROM CatalogoArticulo c"),
    @NamedQuery(name = "CatalogoArticulo.findById", query = "SELECT c FROM CatalogoArticulo c WHERE c.id = :id"),
    @NamedQuery(name = "CatalogoArticulo.findByDescripcion", query = "SELECT c FROM CatalogoArticulo c WHERE c.descripcion = :descripcion")})
public class CatalogoArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @OneToMany(mappedBy = "uncatalogoId", fetch = FetchType.LAZY)
    private List<CategoriaCatalogo> categoriaCatalogoList;
    @OneToMany(mappedBy = "catalogoId", fetch = FetchType.LAZY)
    private List<Empresa> empresaList;

    public CatalogoArticulo() {
    }

    public CatalogoArticulo(Long id) {
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

    @XmlTransient
    public List<CategoriaCatalogo> getCategoriaCatalogoList() {
        return categoriaCatalogoList;
    }

    public void setCategoriaCatalogoList(List<CategoriaCatalogo> categoriaCatalogoList) {
        this.categoriaCatalogoList = categoriaCatalogoList;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
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
        if (!(object instanceof CatalogoArticulo)) {
            return false;
        }
        CatalogoArticulo other = (CatalogoArticulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CatalogoArticulo[ id=" + id + " ]";
    }
    
}
