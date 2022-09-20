package com.sofftektp.trabajofinal.service;

import com.sofftektp.trabajofinal.dto.SellerDTO;

public interface SellerService {
    SellerDTO getByIdSeller(Long id);
    void delete(Long id);
}
