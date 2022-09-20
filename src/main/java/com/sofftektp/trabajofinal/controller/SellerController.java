package com.sofftektp.trabajofinal.controller;


import com.sofftektp.trabajofinal.dto.SellerDTO;
import com.sofftektp.trabajofinal.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<SellerDTO> getManager(@PathVariable @Valid Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.getByIdSeller(id));
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid Long id) {
        sellerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
