package com.sofftektp.trabajofinal.service.impl;

import com.sofftektp.trabajofinal.dto.CustomizationSellerDTO;
import com.sofftektp.trabajofinal.dto.ProductBasicDTO;
import com.sofftektp.trabajofinal.mapper.AreaSellerMapper;
import com.sofftektp.trabajofinal.mapper.CustomizationSellerMapper;
import com.sofftektp.trabajofinal.model.Area;
import com.sofftektp.trabajofinal.model.Customization;
import com.sofftektp.trabajofinal.model.PermittedCustomization;
import com.sofftektp.trabajofinal.model.ProductBasic;
import com.sofftektp.trabajofinal.repository.AreaSellerRepository;
import com.sofftektp.trabajofinal.repository.CustomizationRepository;
import com.sofftektp.trabajofinal.repository.PermittedCustomizationRepository;
import com.sofftektp.trabajofinal.service.CustomizationSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomizationSellerServiceImpl implements CustomizationSellerService {

    @Autowired
    private CustomizationSellerMapper customizationSellerMapper;

    @Autowired
    private PermittedCustomizationRepository permittedCustomization;

    @Autowired
    private CustomizationRepository customizationRepository;

    @Autowired
    private AreaSellerRepository areaSellerRepository;

    @Autowired
    private AreaSellerMapper areaSellerMapper;
    @Override
    public CustomizationSellerDTO saveCustomization(CustomizationSellerDTO customizationSellerDTO) {
        Customization customization = customizationSellerMapper.dtoToEntity(customizationSellerDTO);
        Customization customizationSaved = customizationRepository.save(customization);
        CustomizationSellerDTO res = customizationSellerMapper.entityToDto(customizationSaved);
        return res;
    }
}
