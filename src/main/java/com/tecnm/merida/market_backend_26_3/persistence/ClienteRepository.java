package com.tecnm.merida.market_backend_26_3.persistence;

import com.tecnm.merida.market_backend_26_3.domain.Client;
import com.tecnm.merida.market_backend_26_3.domain.repository.ClientRepository;
import com.tecnm.merida.market_backend_26_3.persistence.crud.ClienteCrudRepository;
import com.tecnm.merida.market_backend_26_3.persistence.entity.Cliente;
import com.tecnm.merida.market_backend_26_3.persistence.mapper.ClientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {

    private final ClienteCrudRepository clienteCrudRepository;
    private final ClientMapper mapper;

    public ClienteRepository(ClienteCrudRepository clienteCrudRepository, ClientMapper mapper) {
        this.clienteCrudRepository = clienteCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Client> getAll() {
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return clientes.stream().map(mapper::toClient).toList();
    }

    @Override
    public Optional<Client> getClient(String clientId) {
        return clienteCrudRepository.findById(clientId).map(mapper::toClient);
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = mapper.toCliente(client);
        return mapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public void delete(String clientId) {
        clienteCrudRepository.deleteById(clientId);
    }
}