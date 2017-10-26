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
@Table(name = "lista_precio", catalog = "gurasoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaPrecio.findAll", query = "SELECT l FROM ListaPrecio l"),
    @NamedQuery(name = "ListaPrecio.findById", query = "SELECT l FROM ListaPrecio l WHERE l.id = :id"),
    @NamedQuery(name = "ListaPrecio.findByDescripcion", query = "SELECT l FROM ListaPrecio l WHERE l.descripcion = :descripcion")})
public class ListaPrecio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @JoinColumn(name = "TIPOCLIENTE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoCliente tipoclienteId;
    @JoinColumn(name = "UNAEMPRESA_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa unaempresaId;

    public ListaPrecio() {
    }

    public ListaPrecio(Long id) {
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

    public TipoCliente getTipoclienteId() {
        return tipoclienteId;
    }

    public void setTipoclienteId(TipoCliente tipoclienteId) {
        this.tipoclienteId = tipoclienteId;
    }

    public Empresa getUnaempresaId() {
        return unaempresaId;
    }

    public void setUnaempresaId(Empresa unaempresaId) {
        this.unaempresaId = unaempresaId;
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
        if (!(object instanceof ListaPrecio)) {
            return false;
        }
        ListaPrecio other = (ListaPrecio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ListaPrecio[ id=" + id + " ]";
    }
    
}
