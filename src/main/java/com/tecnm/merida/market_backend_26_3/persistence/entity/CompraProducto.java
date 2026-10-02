package com.tecnm.merida.market_backend_26_3.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compras_productos")
public class CompraProducto {

    @EmbeddedId
    private CompraProductoPK id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name ="id_producto", insertable = false, updatable = false)
    private Producto producto;




    public CompraProducto() {
    }

    public CompraProducto(CompraProductoPK id, Integer cantidad, Double total, Boolean estado, LocalDateTime fecha) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
        this.fecha = fecha;
    }

    // Getters y Setters
    public CompraProductoPK getId() {
        return id;
    }

    public void setId(CompraProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
