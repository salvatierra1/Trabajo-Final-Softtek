package com.sofftektp.trabajofinal.controller;

import com.sofftektp.trabajofinal.dto.ManagerDTO;
import com.sofftektp.trabajofinal.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<ManagerDTO> getManager(@PathVariable @Valid Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(managerService.getByIdManager(id));
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid Long id) {
        managerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
