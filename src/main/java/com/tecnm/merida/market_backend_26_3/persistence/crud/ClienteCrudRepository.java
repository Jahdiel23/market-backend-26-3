package com.tecnm.merida.market_backend_26_3.persistence.crud;

import com.tecnm.merida.market_backend_26_3.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {
}