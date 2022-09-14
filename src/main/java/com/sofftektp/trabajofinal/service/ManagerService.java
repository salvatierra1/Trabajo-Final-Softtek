package com.sofftektp.trabajofinal.service;

import com.sofftektp.trabajofinal.dto.ManagerDTO;
import com.sofftektp.trabajofinal.model.Manager;

import java.util.Optional;

public interface ManagerService {
    ManagerDTO getByIdManager(Long id);
}
