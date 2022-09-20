package com.sofftektp.trabajofinal.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class ManagerDTO {

    private Long id;

    @NotBlank(message = "the name cannot be empty or null")
    private String name;

    @NotBlank(message = "the username cannot be empty or null")
    private String username;

}
