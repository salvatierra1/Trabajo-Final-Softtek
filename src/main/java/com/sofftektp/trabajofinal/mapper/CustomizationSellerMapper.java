package com.sofftektp.trabajofinal.mapper;

import com.sofftektp.trabajofinal.dto.CustomizationSellerDTO;
import com.sofftektp.trabajofinal.model.Customization;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CustomizationSellerMapper {
    public Customization dtoToEntity(CustomizationSellerDTO customizationSellerDTO) {
        Customization customization = new Customization();
        customization.setName(customizationSellerDTO.getName());
        customization.setPrice(customizationSellerDTO.getPrice());
        return customization;
    }

    public CustomizationSellerDTO entityToDto(Customization customizationSaved) {
        CustomizationSellerDTO customizationSellerDTO = new CustomizationSellerDTO();
        customizationSellerDTO.setId(customizationSaved.getId());
        customizationSellerDTO.setName(customizationSaved.getName());
        customizationSellerDTO.setPrice(customizationSaved.getPrice());
        return customizationSellerDTO;
    }

    public Collection<CustomizationSellerDTO> customizationDTOCollection(Collection<Customization> customizationsCollectionEntities) {
        return customizationsCollectionEntities.stream().map(project -> entityToDto(project)).collect(Collectors.toList());
    }

}
