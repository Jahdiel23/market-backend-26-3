package com.tecnm.merida.market_backend_26_3.web.controller;

import com.tecnm.merida.market_backend_26_3.domain.Product;
import com.tecnm.merida.market_backend_26_3.domain.repository.ProductRepository;
import com.tecnm.merida.market_backend_26_3.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Product", description = "Manage your products")

public class ProductController {

    private ProductService productService;
    private ProductRepository productRepository;

    @GetMapping()
    @Operation(summary = "Get all products",
            description = "Return a list of all available products")
    @ApiResponse(responseCode = "200",
    description = "Succesful retrieval of products")
    @ApiResponse(responseCode = "500",
    description = "Internal server error")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Return a product by its ID if it exists")
    @ApiResponse(responseCode = "200",  description = "Product found")
    @ApiResponse(responseCode = "404",  description = "Product not found")
    @ApiResponse(responseCode = "500",  description = "Internal Server Error")
    public ResponseEntity<Product> getProduct(
            @Parameter(description = "ID of the product to be retrieved",
                    example = "7",
                    required = true)
            @PathVariable("id") int productid) {
        return productService.getProduct(productid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Get products by category",
            description = "Return all products in a specific category")
    @ApiResponse(responseCode = "200",
            description = "Product(s) found in the category")
    @ApiResponse(responseCode = "404",
            description = "Product(s) not found in the category")
    @ApiResponse(responseCode = "500",
            description = "Internal server error")
    public ResponseEntity<List<Product>> getByCategory(
            @Parameter(description = "Category ID",
                    example = "7", required = true)
            @PathVariable("categoryId") int categoryid) {
        return productService.getByCategory(categoryid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @PostMapping("")
    @Operation(
            summary = "Create a new product",
            description = "Register a new product and return it",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example Product",
                                    value =
                                            """
                                            { 
                                               "name" : "Helado",
                                               "categoryId" : 5,
                                               "price" : "19.50",
                                               "stock" : 300,
                                               "active" : true
                                            }                                           
                                            """
                            )
                    )
            )
    )
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