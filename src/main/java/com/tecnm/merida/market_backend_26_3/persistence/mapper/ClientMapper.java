package com.tecnm.merida.market_backend_26_3.persistence.mapper;

import com.tecnm.merida.market_backend_26_3.domain.Client;
import com.tecnm.merida.market_backend_26_3.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toClient(Cliente cliente);

    @InheritInverseConfiguration
    Cliente toCliente(Client client);
}