package com.tecnm.merida.market_backend_26_3.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_compra")
    private Integer idCompra;

    @Column (name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column (name = "medio_pago")
    private String medioPago;

    private String comentario;
    private String estado;

    //Relación con el cliente;
    //Muchas compras para un cliente

    @ManyToOne()
    @JoinColumn(name  = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    //Relación con CompraProducto
    @OneToMany(mappedBy = "compra")
    private List<CompraProducto> productos;

    public Integer getIdCompra() {
        return idCompra;

    }
}
