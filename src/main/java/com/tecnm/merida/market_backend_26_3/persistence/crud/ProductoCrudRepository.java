package com.tecnm.merida.market_backend_26_3.persistence.crud;

import com.tecnm.merida.market_backend_26_3.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    /* SQL Query:
       SELECT *
       FROM productos
       WHERE id_categoria = ?
       ORDER BY nombre ASC
    */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    // Cantidad stock menor que y estado
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}