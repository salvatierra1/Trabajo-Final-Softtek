package com.sofftektp.trabajofinal.service;

import com.sofftektp.trabajofinal.dto.ProductSellerDTO;

public interface ProductSellerService {
    ProductSellerDTO saveProduct(Long id, ProductSellerDTO productSellerDTO);

    ProductSellerDTO getByIdProduct(Long id);

    void delete(Long id);
}
