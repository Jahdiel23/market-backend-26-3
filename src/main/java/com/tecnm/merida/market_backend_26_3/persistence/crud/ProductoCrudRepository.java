package com.tecnm.merida.market_backend_26_3.persistence.crud;

import com.tecnm.merida.market_backend_26_3.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}