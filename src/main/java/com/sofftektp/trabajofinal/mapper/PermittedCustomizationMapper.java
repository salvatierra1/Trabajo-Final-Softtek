package com.sofftektp.trabajofinal.mapper;

import com.sofftektp.trabajofinal.dto.PermittedCustomizationDTO;
import com.sofftektp.trabajofinal.exception.NotFoundException;
import com.sofftektp.trabajofinal.model.PermittedCustomization;
import com.sofftektp.trabajofinal.repository.PermittedCustomizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class PermittedCustomizationMapper {

    @Autowired
    private PermittedCustomizationRepository permittedCustomizationRepository;
    public PermittedCustomization dtoToEntity(PermittedCustomizationDTO permittedCustomizationDTO) {
        PermittedCustomization permittedCustomization = new PermittedCustomization();
        permittedCustomization.setName(permittedCustomizationDTO.getName());
        permittedCustomization.setType(permittedCustomizationDTO.getType());
        permittedCustomization.setPrice(permittedCustomizationDTO.getPrice());
        return permittedCustomization;

    }

    public PermittedCustomizationDTO entityToDto(PermittedCustomization customizationSaved) {
        PermittedCustomizationDTO permittedCustomizationDTO = new PermittedCustomizationDTO();
        permittedCustomizationDTO.setId(customizationSaved.getId());
        permittedCustomizationDTO.setName(customizationSaved.getName());
        permittedCustomizationDTO.setType(customizationSaved.getType());
        permittedCustomizationDTO.setPrice(customizationSaved.getPrice());
        return permittedCustomizationDTO;
    }

    public Collection<PermittedCustomizationDTO> customizationDTOCollection(Collection<PermittedCustomization> permittedCustomizationCollection) {
        return permittedCustomizationCollection.stream().map(project -> entityToDto(project)).collect(Collectors.toList());
    }

    public PermittedCustomization updateEntity(Long id, PermittedCustomizationDTO permittedCustomizationDTO) {
        if (!permittedCustomizationRepository.existsById(id)) {
            throw new NotFoundException("No existe el id: " + id);
        }
        PermittedCustomization permittedCustomization = permittedCustomizationRepository.findById(id).get();
        permittedCustomization.setName(permittedCustomizationDTO.getName());
        permittedCustomization.setType(permittedCustomizationDTO.getType());
        permittedCustomization.setPrice(permittedCustomizationDTO.getPrice());
        return permittedCustomization;
    }
}
