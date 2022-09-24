package com.sofftektp.trabajofinal.service;

import com.sofftektp.trabajofinal.dto.ProductBasicDTO;
import org.springframework.security.core.Authentication;

public interface ProductBasicService {
    ProductBasicDTO getByIdProductBasic(Long id);

    ProductBasicDTO saveProductBasic(Authentication authentication, ProductBasicDTO productBasicDTO);

    ProductBasicDTO addAreaToProduct(Long id, Long idArea);

    void delete(Long id);

    ProductBasicDTO edit(Long id, ProductBasicDTO productBasicDTO);
}
