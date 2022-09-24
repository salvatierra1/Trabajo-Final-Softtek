package com.sofftektp.trabajofinal.service.impl;

import com.sofftektp.trabajofinal.dto.ProductSellerDTO;
import com.sofftektp.trabajofinal.exception.NotFoundException;
import com.sofftektp.trabajofinal.mapper.ProductSellerMapper;
import com.sofftektp.trabajofinal.model.Area;
import com.sofftektp.trabajofinal.model.Customization;
import com.sofftektp.trabajofinal.model.ProductBasic;
import com.sofftektp.trabajofinal.model.ProductSeller;
import com.sofftektp.trabajofinal.repository.*;
import com.sofftektp.trabajofinal.service.ProductSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductSellerServiceImpl implements ProductSellerService {

    @Autowired
    private ProductSellerMapper productSellerMapper;

    @Autowired
    private ProductSellerRepository productSellerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private AreaSellerRepository areaSellerRepository;

    @Autowired
    private ProductBasicRepository productBasicRepository;

    @Autowired
    private CustomizationRepository customizationRepository;

    @Override
    public ProductSellerDTO saveProduct(Long id, ProductSellerDTO productSellerDTO) {
        ProductBasic productBasic = productBasicRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe el id de producto base"));
        ProductSeller productSeller = productSellerMapper.dtoCreateEntity(productBasic, productSellerDTO);
        productBasic.getAreasEnabled().stream().forEach(areaEnabled -> {
            List<Customization> listCustomizations = new ArrayList<>();
            Area area = new Area();
            area.setEnabledArea(areaEnabled);
            Area areaSaved = areaSellerRepository.save(area);
            productSeller.addAreaToSellerProduct(areaSaved);

        });
        productSeller.setProductBasic(productBasic);
        ProductSellerDTO res = productSellerMapper.entityToDto(productSellerRepository.save(productSeller));
        return res;
    }

    @Override
    public ProductSellerDTO getByIdProduct(Long id) {
        Optional<ProductSeller> entity = productSellerRepository.findById(id);
        if (entity.isPresent()) {
            return productSellerMapper.entityToDto(entity.get());
        }
        throw new NotFoundException("No existe el id: " + id);
    }

    @Override
    public void delete(Long id) {
        if (!productSellerRepository.existsById(id)) {
            throw new NotFoundException("No existe el id: " + id);
        }
       /*roductSeller productSeller = productSellerRepository.findById(id).get();
        productSeller.getAreas().stream().forEach(area -> {
            area.getCustomizations().clear();
            area.getCustomizations().stream().forEach(customization -> {
              Long n = customization.getId();
              customizationRepository.deleteById(n);
            });
        });*/
        productSellerRepository.deleteById(id);
    }

}
