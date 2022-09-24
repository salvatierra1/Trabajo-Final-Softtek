package com.sofftektp.trabajofinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sofftektp.trabajofinal.model.Area;
import lombok.Data;

import java.util.Collection;


@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomizationSellerDTO {

    private Long id;

    private String name;

    private Double price;

    private Collection<Area>areasSeller;

}
