package com.distribuida.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table (name = "factura")
public class Factura {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column (name = "id_factura")
    private  int idFactura;
    @Column (name = "num_factura")
    private String numFactura;
    @Column (name = "fecha")
    private Date fecha;
    @Column (name = "total_neto")
    private  Double totalNeto;
    @Column (name = "iva")
    private Double iva;
    @Column (name = "total")
    private  Double total;

    // private int idCliente;
// inyección de dependencias
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private  Cliente cliente;

public Factura(){}
// inyector por constructor
    public Factura(int idFactura, Cliente cliente, Double total, Double iva, Double totalNeto, Date fecha, String numFactura) {
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.total = total;
        this.iva = iva;
        this.totalNeto = totalNeto;
        this.fecha = fecha;
        this.numFactura = numFactura;
    }

    public static Factura orElse(Object o) {
        return null;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public Double getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(Double totalNeto) {
        this.totalNeto = totalNeto;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", numFactura='" + numFactura + '\'' +
                ", fecha=" + fecha +
                ", totalNeto=" + totalNeto +
                ", iva=" + iva +
                ", total=" + total +
                ", cliente=" + cliente +
                '}';
    }
}
