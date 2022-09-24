package com.sofftektp.trabajofinal.service;

import com.sofftektp.trabajofinal.dto.AreaSellerDTO;
import com.sofftektp.trabajofinal.model.Area;

public interface AreaSellerService {

    AreaSellerDTO getByIdArea(Long id);

    AreaSellerDTO addCustomizationToArea(Long id, Long idCustomization);
}
