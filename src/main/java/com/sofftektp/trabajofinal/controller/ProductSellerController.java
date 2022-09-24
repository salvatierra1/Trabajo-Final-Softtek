package com.sofftektp.trabajofinal.controller;


import com.sofftektp.trabajofinal.dto.ProductSellerDTO;
import com.sofftektp.trabajofinal.service.ProductSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/productSeller")
public class ProductSellerController {

    @Autowired
    private ProductSellerService productSellerService;

    //=== Post ===
    @PostMapping("/{id}")
    public ResponseEntity<ProductSellerDTO> saveProduct(@Valid @PathVariable Long id, @RequestBody @Valid ProductSellerDTO productSellerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(productSellerService.saveProduct(id,productSellerDTO));
    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<ProductSellerDTO> getByIdProduct(@PathVariable @Valid Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productSellerService.getByIdProduct(id));
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
        productSellerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
