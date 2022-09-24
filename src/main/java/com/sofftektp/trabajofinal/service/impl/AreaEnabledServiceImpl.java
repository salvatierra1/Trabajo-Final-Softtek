package com.sofftektp.trabajofinal.service.impl;

import com.sofftektp.trabajofinal.dto.AreaEnabledDTO;
import com.sofftektp.trabajofinal.exception.BadRequestException;
import com.sofftektp.trabajofinal.exception.NotFoundException;
import com.sofftektp.trabajofinal.mapper.AreaEnabledMapper;
import com.sofftektp.trabajofinal.model.AreaEnabled;
import com.sofftektp.trabajofinal.model.PermittedCustomization;
import com.sofftektp.trabajofinal.repository.AreaEnabledRepository;
import com.sofftektp.trabajofinal.repository.PermittedCustomizationRepository;
import com.sofftektp.trabajofinal.service.AreaEnabledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaEnabledServiceImpl implements AreaEnabledService {

    @Autowired
    private AreaEnabledMapper areaEnabledMapper;

    @Autowired
    private AreaEnabledRepository areaEnabledRepository;

    @Autowired
    private PermittedCustomizationRepository permittedCustomizationRepository;

    @Override
    public AreaEnabledDTO saveAreaEnabled(AreaEnabledDTO areaEnabled) {

        List<AreaEnabled> areasEnableds = areaEnabledRepository.findAll();
        if (areasEnableds.stream().anyMatch(a -> a.getName().equals(areaEnabled.getName()))) {
            throw new BadRequestException("Ya existe area " + areaEnabled.getName());
        }
        AreaEnabled areaEnable = areaEnabledMapper.dtoToEntity(areaEnabled);
        AreaEnabled areaEnabledSaved = areaEnabledRepository.save(areaEnable);
        AreaEnabledDTO res = areaEnabledMapper.entityToDto(areaEnabledSaved);
        return res;

    }

    @Override
    public AreaEnabledDTO getByIdAreaEnabled(Long id) {
        Optional<AreaEnabled> entity = this.areaEnabledRepository.findById(id);
        if (entity.isPresent()) {
            return areaEnabledMapper.entityToDto(entity.get());
        }
        throw new NotFoundException("No existe el id: " + id);
    }

    @Override
    public void delete(Long id) {
        if (!areaEnabledRepository.existsById(id)) {
            throw new NotFoundException("No existe el id: " + id);
        }
        areaEnabledRepository.deleteById(id);
    }

    @Override
    public AreaEnabledDTO addCustomizationToArea(Long id, Long idCustomization) {
        if(!areaEnabledRepository.existsById(id)) {
            throw new NotFoundException("No existe el " + id + " area");

        }if(!areaEnabledRepository.existsById(idCustomization)) {
            throw new NotFoundException("No existe el " + idCustomization + " personalizacion");

        }
        AreaEnabled  areaEnabled = areaEnabledRepository.findById(id).get();
        PermittedCustomization permittedCustomization = permittedCustomizationRepository.findById(idCustomization).get();
        if(areaEnabled.getPermittedCustomizationCollection().stream().anyMatch(a-> a.getType().equals(permittedCustomization.getType()))){
            throw new BadRequestException("El producto base ya cuenta con area: " + permittedCustomization.getType());
        }
        areaEnabled.addCustomizationToArea(permittedCustomization);
        areaEnabledRepository.save(areaEnabled);
        return areaEnabledMapper.entityToDto(areaEnabled);
    }

    @Override
    public AreaEnabledDTO edit(Long id, AreaEnabledDTO areaEnabledDTO) {
        AreaEnabled areaEnabled = areaEnabledMapper.updateEntity(id, areaEnabledDTO);
        return areaEnabledMapper.entityToDto(areaEnabledRepository.save(areaEnabled));
    }

}


