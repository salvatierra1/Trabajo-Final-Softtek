package com.sofftektp.trabajofinal.controller;

import com.sofftektp.trabajofinal.dto.ProductBasicDTO;
import com.sofftektp.trabajofinal.service.ProductBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/productBasic")
public class ProductBasicController {

    @Autowired
    private ProductBasicService productBasicService;

    //=== Post ===
    @PostMapping("/{id}")
    public ResponseEntity<ProductBasicDTO> saveProductBasic(@Valid @PathVariable Long id, @RequestBody @Valid ProductBasicDTO productBasicDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(productBasicService.saveProductBasic(id, productBasicDTO));
    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<ProductBasicDTO> getProductBasic(@Valid @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productBasicService.getByIdProductBasic(id));
    }

    //=== Put ===
    @PutMapping("/{id}")
    public ResponseEntity<ProductBasicDTO>edit(@Valid @PathVariable Long id, @Valid @RequestBody ProductBasicDTO productBasicDTO){
        return  ResponseEntity.status(HttpStatus.OK).body(productBasicService.edit(id,productBasicDTO));
    }


    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
        productBasicService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/add/{idArea}")
    ResponseEntity<ProductBasicDTO> addAreaToProduct(@Valid @PathVariable Long id, @Valid @PathVariable Long idArea) {
        return ResponseEntity.ok(productBasicService.addAreaToProduct(id, idArea));
    }

}
