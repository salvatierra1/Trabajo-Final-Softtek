package com.sofftektp.trabajofinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;



@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PermittedCustomizationDTO {

    private Long id;

    @NotBlank(message = "the type cannot be empty or null")
    private String type;


}
