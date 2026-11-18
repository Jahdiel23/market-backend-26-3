package com.tecnm.merida.market_backend_26_3.web.controller;

import com.tecnm.merida.market_backend_26_3.domain.Purchase;
import com.tecnm.merida.market_backend_26_3.domain.service.PurchaseService;
import com.tecnm.merida.market_backend_26_3.persistence.mapper.PurchaseRequestMapper;
import com.tecnm.merida.market_backend_26_3.web.controller.dto.PurchaseRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final PurchaseRequestMapper purchaseRequestMapper;

    public PurchaseController(
            PurchaseService purchaseService,
            PurchaseRequestMapper purchaseRequestMapper) {
        this.purchaseService = purchaseService;
        this.purchaseRequestMapper = purchaseRequestMapper;
    }

    @GetMapping
    public List<Purchase> getAll() {
        return purchaseService.getAll();
    }

    @GetMapping("/client/{clientId}")
    public Optional<List<Purchase>> getByClient(@PathVariable String clientId) {
        return purchaseService.getByClient(clientId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Purchase save(@RequestBody PurchaseRequest request) {
        Purchase purchase = purchaseRequestMapper.toPurchase(request);
        return purchaseService.save(purchase);
    }
}