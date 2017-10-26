/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ariel
 */
@Entity
@DiscriminatorValue(value = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findByType", query = "SELECT c FROM Cliente c WHERE c.tipocliente = :type")})
public class Cliente extends Persona {

    @ManyToOne
    private CuentaCorriente cuentaCorriente;

    @ManyToOne
    private TipoCliente tipocliente;

    @OneToMany(mappedBy = "clienteId", fetch = FetchType.LAZY)
    private List<Venta> ventaList;
    
    @JoinColumn(name = "CUENTACORRIENTE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CuentaCorriente cuentacorrienteId;

    @JoinColumn(name = "TIPOCLIENTE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoCliente tipoclienteId;
    
    
    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public CuentaCorriente getCuentacorrienteId() {
        return cuentacorrienteId;
    }

    public void setCuentacorrienteId(CuentaCorriente cuentacorrienteId) {
        this.cuentacorrienteId = cuentacorrienteId;
    }
    
    public TipoCliente getTipoclienteId() {
        return tipoclienteId;
    }

    public void setTipoclienteId(TipoCliente tipoclienteId) {
        this.tipoclienteId = tipoclienteId;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public TipoCliente getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(TipoCliente tipocliente) {
        this.tipocliente = tipocliente;
    }

    
}
