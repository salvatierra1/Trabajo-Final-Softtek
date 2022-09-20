package com.sofftektp.trabajofinal.service.impl;

import com.sofftektp.trabajofinal.dto.PermittedCustomizationDTO;
import com.sofftektp.trabajofinal.exception.NotFoundException;
import com.sofftektp.trabajofinal.mapper.PermittedCustomizationMapper;
import com.sofftektp.trabajofinal.model.PermittedCustomization;
import com.sofftektp.trabajofinal.repository.PermittedCustomizationRepository;
import com.sofftektp.trabajofinal.service.PermittedCustomizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermittedCustomizationServiceImpl implements PermittedCustomizationService {

    @Autowired
    private PermittedCustomizationMapper permittedCustomizationMapper;
    @Autowired
    private PermittedCustomizationRepository permittedCustomizationRepository;

    @Override
    public PermittedCustomizationDTO saveCustomization(PermittedCustomizationDTO permittedCustomizationDTO) {
        PermittedCustomization customization = permittedCustomizationMapper.dtoToEntity(permittedCustomizationDTO);
        PermittedCustomization customizationSaved = permittedCustomizationRepository.save(customization);
        PermittedCustomizationDTO res = permittedCustomizationMapper.entityToDto(customizationSaved);
        return res;
    }

    @Override
    public PermittedCustomizationDTO getByIdCustomization(Long id) {
        Optional<PermittedCustomization> entity = this.permittedCustomizationRepository.findById(id);
        if (entity.isPresent()) {
            return permittedCustomizationMapper.entityToDto(entity.get());
        }
        throw new NotFoundException("No existe el id: " + id);
    }

    @Override
    public void delete(Long id) {
        if (!permittedCustomizationRepository.existsById(id)) {
            throw new NotFoundException("No existe el id: " + id);
        }
        permittedCustomizationRepository.deleteById(id);
    }

    @Override
    public PermittedCustomizationDTO edit(Long id, PermittedCustomizationDTO permittedCustomizationDTO) {
        PermittedCustomization permittedCustomization = permittedCustomizationMapper.updateEntity(id, permittedCustomizationDTO);
        return permittedCustomizationMapper.entityToDto(permittedCustomizationRepository.save(permittedCustomization));
    }

}
