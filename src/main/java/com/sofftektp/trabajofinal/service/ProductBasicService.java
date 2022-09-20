package com.sofftektp.trabajofinal.service;

import com.sofftektp.trabajofinal.dto.ProductBasicDTO;

public interface ProductBasicService {
    ProductBasicDTO getByIdProductBasic(Long id);

    ProductBasicDTO saveProductBasic(Long id, ProductBasicDTO productBasicDTO);

    ProductBasicDTO addAreaToProduct(Long id, Long idArea);

    void delete(Long id);

    ProductBasicDTO edit(Long id, ProductBasicDTO productBasicDTO);
}
