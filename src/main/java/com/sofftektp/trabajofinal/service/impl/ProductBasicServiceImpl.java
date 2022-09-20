package com.sofftektp.trabajofinal.service.impl;

import com.sofftektp.trabajofinal.dto.ProductBasicDTO;
import com.sofftektp.trabajofinal.exception.BadRequestException;
import com.sofftektp.trabajofinal.exception.NotFoundException;
import com.sofftektp.trabajofinal.mapper.ProductBasicMapper;
import com.sofftektp.trabajofinal.model.AreaEnabled;
import com.sofftektp.trabajofinal.model.ProductBasic;
import com.sofftektp.trabajofinal.repository.AreaEnabledRepository;
import com.sofftektp.trabajofinal.repository.ManagerRepository;
import com.sofftektp.trabajofinal.repository.ProductBasicRepository;
import com.sofftektp.trabajofinal.service.ProductBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ProductBasicServiceImpl implements ProductBasicService {

    @Autowired
    private ProductBasicRepository productBasicRepository;
    @Autowired
    private ProductBasicMapper productBasicMapper;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private AreaEnabledRepository areaEnabledRepository;

    @Override
    public ProductBasicDTO saveProductBasic(Long id, ProductBasicDTO productBasicDTO) {
        ProductBasic productBasic = productBasicMapper.dtoToEntity(productBasicDTO);
        productBasic.setManager(managerRepository.findById(id).get());
        ProductBasic productBasicSaved = productBasicRepository.save(productBasic);
        ProductBasicDTO res = productBasicMapper.entityToDto(productBasicSaved);
        return res;
    }

    @Override
    public ProductBasicDTO addAreaToProduct(Long id, Long idArea) {
        if (!productBasicRepository.existsById(id)) {
            throw new NotFoundException("No existe el " + id + " del producto base");
        }

        ProductBasic productBasic = productBasicRepository.findById(id).get();
        AreaEnabled enabledArea = areaEnabledRepository.findById(idArea).get();
        if (productBasic.getAreasEnabled().stream().anyMatch(a -> a.getName().equals(enabledArea.getName()))) {
            throw new BadRequestException("El producto base ya cuenta con area: " + enabledArea.getName());
        }
        productBasic.addAreaToBaseProduct(enabledArea);
        productBasicRepository.save(productBasic);
        return productBasicMapper.entityToDto(productBasic);
    }

    @Override
    public ProductBasicDTO getByIdProductBasic(Long id) {
        Optional<ProductBasic> entity = productBasicRepository.findById(id);
        if (entity.isPresent()) {
            return productBasicMapper.entityToDto(entity.get());
        }
        throw new NotFoundException("No existe el id: " + id);
    }

    @Override
    public void delete(Long id) {
        if (!productBasicRepository.existsById(id)) {
            throw new NotFoundException("No existe el id: " + id);
        }
        productBasicRepository.deleteById(id);
    }

    @Override
    public ProductBasicDTO edit(Long id, ProductBasicDTO productBasicDTO) {
        ProductBasic productBasic = productBasicMapper.updateEntity(id, productBasicDTO);
        return productBasicMapper.entityToDto(productBasicRepository.save(productBasic));
    }

}
