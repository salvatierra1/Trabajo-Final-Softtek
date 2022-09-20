package com.sofftektp.trabajofinal.service;

import com.sofftektp.trabajofinal.dto.PermittedCustomizationDTO;

public interface PermittedCustomizationService {
    PermittedCustomizationDTO saveCustomization(PermittedCustomizationDTO permittedCustomizationDTO);
    PermittedCustomizationDTO getByIdCustomization(Long id);

    void delete(Long id);

    PermittedCustomizationDTO edit(Long id, PermittedCustomizationDTO permittedCustomizationDTO);
}
