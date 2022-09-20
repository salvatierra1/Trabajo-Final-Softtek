package com.sofftektp.trabajofinal.service;

import com.sofftektp.trabajofinal.dto.AreaEnabledDTO;

public interface AreaEnabledService {
    AreaEnabledDTO saveAreaEnabled(AreaEnabledDTO areaEnabled);

    AreaEnabledDTO getByIdAreaEnabled(Long id);

    void delete(Long id);

    AreaEnabledDTO addCustomizationToArea(Long id, Long idCustomization);

    AreaEnabledDTO edit(Long id, AreaEnabledDTO areaEnabledDTO);
}
