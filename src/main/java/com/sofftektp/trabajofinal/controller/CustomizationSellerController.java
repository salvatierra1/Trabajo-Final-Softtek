package com.sofftektp.trabajofinal.controller;

import com.sofftektp.trabajofinal.dto.CustomizationSellerDTO;
import com.sofftektp.trabajofinal.service.CustomizationSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customizationSeller")
public class CustomizationSellerController {

    @Autowired
    private CustomizationSellerService customizationSellerService;

    //=== Post ===
    @PostMapping("/{id}")
    public ResponseEntity<CustomizationSellerDTO> saveProduct(@RequestBody @Valid CustomizationSellerDTO customizationSellerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(customizationSellerService.saveCustomization(customizationSellerDTO));
    }

}
