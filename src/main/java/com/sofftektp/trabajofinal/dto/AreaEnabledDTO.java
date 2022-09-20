package com.sofftektp.trabajofinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AreaEnabledDTO {

    private Long id;

    @NotBlank(message = "the name cannot be empty or null")
    private String name;

    private Collection<PermittedCustomizationDTO> permittedCustomization;

}
