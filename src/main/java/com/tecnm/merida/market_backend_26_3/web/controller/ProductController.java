package com.tecnm.merida.market_backend_26_3.web.controller;

import com.tecnm.merida.market_backend_26_3.domain.Product;
import com.tecnm.merida.market_backend_26_3.domain.repository.ProductRepository;
import com.tecnm.merida.market_backend_26_3.domain.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private ProductRepository productRepository;

    @GetMapping()
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productid) {
        return productService.getProduct(productid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(
            @PathVariable("categoryId") int categoryid) {
        return productService.getByCategory(categoryid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") int productId) {
        if (productService.delete(productId)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}