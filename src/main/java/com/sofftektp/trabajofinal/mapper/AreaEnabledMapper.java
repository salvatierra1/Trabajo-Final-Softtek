package com.sofftektp.trabajofinal.mapper;

import com.sofftektp.trabajofinal.dto.AreaEnabledDTO;
import com.sofftektp.trabajofinal.exception.NotFoundException;
import com.sofftektp.trabajofinal.model.AreaEnabled;
import com.sofftektp.trabajofinal.repository.AreaEnabledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class AreaEnabledMapper {

    @Autowired
    private PermittedCustomizationMapper permittedCustomizationMapper;

    @Autowired
    private AreaEnabledRepository areaEnabledRepository;

    public AreaEnabled dtoToEntity(AreaEnabledDTO areaEnabled) {
        AreaEnabled areaEnable = new AreaEnabled();
        areaEnable.setName(areaEnabled.getName());
        return areaEnable;
    }

    public AreaEnabledDTO entityToDto(AreaEnabled areaEnabledSaved) {
        AreaEnabledDTO areaEnable = new AreaEnabledDTO();
        areaEnable.setId(areaEnabledSaved.getId());
        areaEnable.setName(areaEnabledSaved.getName());
        areaEnable.setPermittedCustomizations(permittedCustomizationMapper.customizationDTOCollection(areaEnabledSaved.getPermittedCustomizationCollection()));
        return areaEnable;
    }

    public Collection<AreaEnabledDTO> areaEnabledDTOCollection(Collection<AreaEnabled> areaEnabledCollectionEntities) {
        return areaEnabledCollectionEntities.stream().map(project -> entityToDto(project)).collect(Collectors.toList());
    }

    public AreaEnabled updateEntity(Long id, AreaEnabledDTO areaEnabledDTO) {
        if (!areaEnabledRepository.existsById(id)) {
            throw new NotFoundException("No existe el id: " + id);
        }
        AreaEnabled areaEnable = areaEnabledRepository.findById(id).get();
        areaEnable.setName(areaEnabledDTO.getName());
        return areaEnable;
    }

}
