package com.sofftektp.trabajofinal.mapper;

import com.sofftektp.trabajofinal.dto.ProductSellerDTO;
import com.sofftektp.trabajofinal.model.ProductBasic;
import com.sofftektp.trabajofinal.model.ProductSeller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductSellerMapper {

    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private ProductBasicMapper productBasicMapper;

    @Autowired
    private AreaEnabledMapper areaEnabledMapper;

    @Autowired
    private AreaSellerMapper areaSellerMapper;

    @Autowired
    private CustomizationSellerMapper customizationSellerMapper;

    public ProductSeller dtoToEntity(ProductSellerDTO productSellerDTO) {
        ProductSeller productSeller = new ProductSeller();
        productSeller.setPriceBasic(productSellerDTO.getPriceBasic());
        return productSeller;
    }

    public ProductSellerDTO entityToDto(ProductSeller productSellerSaved) {
        ProductSellerDTO productSellerDTO = new ProductSellerDTO();
        productSellerDTO.setId(productSellerSaved.getId());
        productSellerDTO.setPriceFinal(productSellerSaved.getPriceFinal());
        productSellerDTO.setProductBasic((productBasicMapper.entityToDtoBasic(productSellerSaved.getProductBasic())));
        productSellerDTO.setAreas(areaSellerMapper.areaDTOCollection(productSellerSaved.getAreasSeller()));
        return productSellerDTO;
    }

    public ProductSeller dtoCreateEntity(ProductBasic productBasic, ProductSellerDTO productSellerDTO) {
        ProductSeller productSeller = this.dtoToEntity(productSellerDTO);
        productSeller.setProductBasic(productBasic);
        return productSeller;

    }
}
