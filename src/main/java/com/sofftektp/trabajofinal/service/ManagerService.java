package com.sofftektp.trabajofinal.service;

import com.sofftektp.trabajofinal.dto.ManagerDTO;


public interface ManagerService {
    ManagerDTO getByIdManager(Long id);
    void delete(Long id);
}
