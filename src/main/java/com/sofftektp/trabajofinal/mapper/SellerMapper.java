package com.sofftektp.trabajofinal.mapper;

import com.sofftektp.trabajofinal.dto.SellerDTO;
import com.sofftektp.trabajofinal.model.Seller;
import org.springframework.stereotype.Component;

@Component
public class SellerMapper {
    public SellerDTO EntityToDto(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setId(seller.getId());
        sellerDTO.setName(seller.getUserEntity().getName());
        sellerDTO.setUsername(seller.getUserEntity().getUsername());
        return sellerDTO;
    }

}
