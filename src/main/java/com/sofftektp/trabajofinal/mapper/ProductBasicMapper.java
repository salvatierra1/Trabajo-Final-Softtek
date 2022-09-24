package com.sofftektp.trabajofinal.mapper;

import com.sofftektp.trabajofinal.dto.ProductBasicDTO;
import com.sofftektp.trabajofinal.exception.NotFoundException;
import com.sofftektp.trabajofinal.model.ProductBasic;
import com.sofftektp.trabajofinal.repository.ProductBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductBasicMapper {

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private AreaEnabledMapper areaEnabledMapper;

    @Autowired
    private ProductBasicRepository productBasicRepository;

    public ProductBasic dtoToEntity(ProductBasicDTO productBasicDTO) {

        ProductBasic productBasic = new ProductBasic();
        productBasic.setDescription(productBasicDTO.getDescription());
        productBasic.setName(productBasicDTO.getName());
        productBasic.setProductionTime(productBasicDTO.getProductionTime());
        return productBasic;

    }

    public ProductBasicDTO entityToDto(ProductBasic productBasic) {
        ProductBasicDTO dto = new ProductBasicDTO();
        dto.setId(productBasic.getId());
        dto.setName(productBasic.getName());
        dto.setDescription(productBasic.getDescription());
        dto.setProductionTime(productBasic.getProductionTime());
        dto.setManager((managerMapper.managerEntity2Dto(productBasic.getManager())));
        dto.setAreasPermitted(areaEnabledMapper.areaEnabledDTOCollection(productBasic.getAreasEnabled()));
        return dto;
    }

    public ProductBasic updateEntity(Long id, ProductBasicDTO productBasicDTO) {
        if (!productBasicRepository.existsById(id)) {
            throw new NotFoundException("No existe el id: " + id);
        }
        ProductBasic productBasic = productBasicRepository.findById(id).get();
        productBasic.setDescription(productBasicDTO.getDescription());
        productBasic.setName(productBasicDTO.getName());
        productBasic.setProductionTime(productBasicDTO.getProductionTime());
        return productBasic;
    }

    public ProductBasicDTO entityToDtoBasic(ProductBasic productBasic) {
        ProductBasicDTO dto = new ProductBasicDTO();
        dto.setName(productBasic.getName());
        dto.setDescription(productBasic.getDescription());
        dto.setProductionTime(productBasic.getProductionTime());
        return dto;
    }
}
