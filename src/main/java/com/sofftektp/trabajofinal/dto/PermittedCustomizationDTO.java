package com.sofftektp.trabajofinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PermittedCustomizationDTO {

    private Long id;

    @NotBlank(message = "the name cannot be empty or null")
    private String name;

    @NotBlank(message = "the type cannot be empty or null")
    private String type;

    @NotNull(message = "the price cannot be null")
    private Double price;

}
