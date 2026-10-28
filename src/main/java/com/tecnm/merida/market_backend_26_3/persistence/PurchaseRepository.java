package com.tecnm.merida.market_backend_26_3.persistence;

import com.tecnm.merida.market_backend_26_3.domain.Purchase;
import com.tecnm.merida.market_backend_26_3.persistence.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient (String clientId);
    Purchase save(Purchase purchase);
}
