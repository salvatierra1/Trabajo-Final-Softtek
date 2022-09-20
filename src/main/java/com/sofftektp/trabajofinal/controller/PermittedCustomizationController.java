package com.sofftektp.trabajofinal.controller;

import com.sofftektp.trabajofinal.dto.PermittedCustomizationDTO;
import com.sofftektp.trabajofinal.service.PermittedCustomizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/permittedCustomization")
public class PermittedCustomizationController {

    @Autowired
    private PermittedCustomizationService permittedCustomizationService;

    //=== Post ===
    @PostMapping()
    public ResponseEntity<PermittedCustomizationDTO> saveCustomization(@RequestBody @Valid PermittedCustomizationDTO permittedCustomizationDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(permittedCustomizationService.saveCustomization(permittedCustomizationDTO));
    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<PermittedCustomizationDTO> getCustomization(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.OK).body(permittedCustomizationService.getByIdCustomization(id));
    }

    //=== Put ===
    @PutMapping("/{id}")
    public ResponseEntity<PermittedCustomizationDTO>edit(@Valid @PathVariable Long id, @Valid @RequestBody PermittedCustomizationDTO permittedCustomizationDTO){
        return  ResponseEntity.status(HttpStatus.OK).body(permittedCustomizationService.edit(id, permittedCustomizationDTO));
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid Long id) {
        permittedCustomizationService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
