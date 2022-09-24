package com.sofftektp.trabajofinal.service.impl;

import com.sofftektp.trabajofinal.dto.AreaSellerDTO;
import com.sofftektp.trabajofinal.exception.BadRequestException;
import com.sofftektp.trabajofinal.exception.NotFoundException;
import com.sofftektp.trabajofinal.mapper.AreaSellerMapper;
import com.sofftektp.trabajofinal.model.Area;
import com.sofftektp.trabajofinal.model.AreaEnabled;
import com.sofftektp.trabajofinal.model.Customization;
import com.sofftektp.trabajofinal.model.PermittedCustomization;
import com.sofftektp.trabajofinal.repository.AreaSellerRepository;
import com.sofftektp.trabajofinal.repository.CustomizationRepository;
import com.sofftektp.trabajofinal.service.AreaSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaSellerServiceImpl implements AreaSellerService {

    @Autowired
    private AreaSellerRepository areaSellerRepository;

    @Autowired
    private AreaSellerMapper areaSellerMapper;

    @Autowired
    private CustomizationRepository customizationRepository;


    @Override
    public AreaSellerDTO getByIdArea(Long id) {
       Area area =  areaSellerRepository.findById(id).get();
        return areaSellerMapper.entityToDto(area);
    }

    @Override
    public AreaSellerDTO addCustomizationToArea(Long id, Long idCustomization) {
        Area enabledArea = areaSellerRepository.findById(id).get();
        Customization customization = customizationRepository.findById(idCustomization).get();
        enabledArea.addCustomizationToArea(customization);
        areaSellerRepository.save(enabledArea);
        return areaSellerMapper.entityToDto(enabledArea);
    }

}
