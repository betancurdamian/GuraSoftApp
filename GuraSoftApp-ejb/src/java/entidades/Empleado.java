/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
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
@DiscriminatorValue(value = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findByType", query = "SELECT e FROM Empleado e WHERE e.tipoempleadoId = :type")})
public class Empleado extends Persona {
    
    @OneToMany(mappedBy = "empleadoId", fetch = FetchType.LAZY)
    private List<Venta> ventaList1;
    
    @JoinColumn(name = "TIPOEMPLEADO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoEmpleado tipoempleadoId;
    
    @JoinColumn(name = "UNUSUARIO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario unusuarioId;
    
    @XmlTransient
    public List<Venta> getVentaList1() {
        return ventaList1;
    }

    public void setVentaList1(List<Venta> ventaList1) {
        this.ventaList1 = ventaList1;
    }

    public TipoEmpleado getTipoempleadoId() {
        return tipoempleadoId;
    }

    public void setTipoempleadoId(TipoEmpleado tipoempleadoId) {
        this.tipoempleadoId = tipoempleadoId;
    }
    
    public Usuario getUnusuarioId() {
        return unusuarioId;
    }

    public void setUnusuarioId(Usuario unusuarioId) {
        this.unusuarioId = unusuarioId;
    }    
}