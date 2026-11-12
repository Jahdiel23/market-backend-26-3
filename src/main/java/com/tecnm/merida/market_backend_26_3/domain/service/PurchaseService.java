package com.tecnm.merida.market_backend_26_3.domain.service;


import com.tecnm.merida.market_backend_26_3.domain.Purchase;
import com.tecnm.merida.market_backend_26_3.domain.repository.ProductRepository;
import com.tecnm.merida.market_backend_26_3.persistence.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();

    }

    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
    }

    public Purchase save (Purchase purchase) {
        return purchaseRepository.save(purchase);

    }
}
