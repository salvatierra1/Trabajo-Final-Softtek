package com.sofftektp.trabajofinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sofftektp.trabajofinal.model.Customization;
import lombok.Data;

import java.util.Collection;


@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductSellerDTO {

    private Long id;

    private Double priceBasic;

    private Double priceFinal;

    @JsonProperty("Product Basic")
    private ProductBasicDTO productBasic;

    @JsonProperty("Areas Permitted")
    private Collection<AreaSellerDTO> areas;

    @JsonProperty("Seller Customization")
    private Collection<Customization> customizations;

}
