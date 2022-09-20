package com.sofftektp.trabajofinal.controller;

import com.sofftektp.trabajofinal.dto.AreaEnabledDTO;
import com.sofftektp.trabajofinal.service.AreaEnabledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/areaEnabled")
public class AreaEnabledController {

    @Autowired
    private AreaEnabledService areaEnabledService;

    //=== Post ===
    @PostMapping()
    public ResponseEntity<AreaEnabledDTO> saveAreaEnabled(@RequestBody @Valid AreaEnabledDTO areaEnabled) {
        return ResponseEntity.status(HttpStatus.OK).body(areaEnabledService.saveAreaEnabled(areaEnabled));
    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<AreaEnabledDTO> getAreaEnabled(@PathVariable @Valid Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(areaEnabledService.getByIdAreaEnabled(id));
    }

    //=== Put ===
    @PutMapping("/{id}")
    public ResponseEntity<AreaEnabledDTO>edit(@Valid @PathVariable Long id, @Valid @RequestBody AreaEnabledDTO areaEnabledDTO){
        return  ResponseEntity.status(HttpStatus.OK).body(areaEnabledService.edit(id,areaEnabledDTO));
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid Long id) {
        areaEnabledService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/add/{idCustomization}")
    ResponseEntity<AreaEnabledDTO> addCustomizationToArea(@PathVariable @Valid Long id, @PathVariable @Valid Long idCustomization) {
        return ResponseEntity.ok(areaEnabledService.addCustomizationToArea(id, idCustomization));
    }

}
