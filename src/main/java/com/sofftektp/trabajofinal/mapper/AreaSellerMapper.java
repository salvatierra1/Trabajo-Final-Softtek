package com.sofftektp.trabajofinal.mapper;

import com.sofftektp.trabajofinal.dto.AreaSellerDTO;
import com.sofftektp.trabajofinal.model.Area;
import com.sofftektp.trabajofinal.model.AreaEnabled;
import com.sofftektp.trabajofinal.repository.AreaEnabledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class AreaSellerMapper {

    @Autowired
    private CustomizationSellerMapper customizationSellerMapper;
    @Autowired
    private AreaEnabledRepository areaEnabledRepository;

    public Collection<AreaSellerDTO> areaDTOCollection(Collection<Area> areaCollectionEntities) {
        return areaCollectionEntities.stream().map(project -> entityToDto(project)).collect(Collectors.toList());
    }

    public AreaSellerDTO entityToDto(Area area) {
        AreaSellerDTO entity = new AreaSellerDTO();
        entity.setId(area.getId());
        entity.setName(area.getEnabledArea().getName());
        Long ar = area.getEnabledArea().getId();
        AreaEnabled areaEnabled = areaEnabledRepository.findById(ar).get();
        areaEnabled.getPermittedCustomizationCollection().stream().forEach(areaBasic -> {
            areaBasic.getType();
            entity.setType(areaBasic.getType());
                });
        entity.setCustomizations(customizationSellerMapper.customizationDTOCollection(area.getCustomizations()));
        return entity;
    }


}
