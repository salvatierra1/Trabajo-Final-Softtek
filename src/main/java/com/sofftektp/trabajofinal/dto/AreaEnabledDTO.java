package com.sofftektp.trabajofinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Collection;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AreaEnabledDTO {

    private Long id;

    private String name;

    private Collection<PermittedCustomizationDTO> permittedCustomizations;

}
