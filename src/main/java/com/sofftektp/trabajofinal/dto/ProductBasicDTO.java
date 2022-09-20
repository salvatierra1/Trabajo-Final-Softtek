package com.sofftektp.trabajofinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;



@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductBasicDTO {

    private Long id;

    @NotBlank(message = "the name cannot be empty or null")
    private String name;

    @NotBlank(message = "the description cannot be empty or null")
    private String description;

    @NotNull(message = "the productionTime cannot be null")
    private Long productionTime;

    private ManagerDTO manager;

    private Collection<AreaEnabledDTO> areas;

}
