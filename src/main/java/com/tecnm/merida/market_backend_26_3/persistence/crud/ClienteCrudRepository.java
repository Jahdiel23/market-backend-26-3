package com.tecnm.merida.market_backend_26_3.persistence.crud;

import com.tecnm.merida.market_backend_26_3.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {

    Optional<Cliente> findByCorreoElectronico(String correoElectronico);

}
