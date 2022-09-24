package com.sofftektp.trabajofinal.controller;

import com.sofftektp.trabajofinal.dto.AreaSellerDTO;
import com.sofftektp.trabajofinal.service.AreaSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/areaSeller")
public class AreaSellerController {

    @Autowired
    private AreaSellerService  areaService;

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<AreaSellerDTO> getArea(@PathVariable @Valid Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(areaService.getByIdArea(id));
    }

    @PostMapping("/{id}/add/{idCustomization}")
    ResponseEntity<AreaSellerDTO> addAreaToProduct(@Valid @PathVariable Long id, @Valid @PathVariable Long idCustomization) {
        return ResponseEntity.ok(areaService.addCustomizationToArea(id, idCustomization));
    }

}
