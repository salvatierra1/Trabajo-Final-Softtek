package com.sofftektp.trabajofinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AreaSellerDTO {

    private Long id;

    private String name;

    @JsonProperty("Customization Permitted")
    private String type;

    @JsonProperty("Seller Customization")
    private Collection<CustomizationSellerDTO> customizations;

}
