package com.sofftektp.trabajofinal.auth.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String name;

    @Email(message = "Username must be an email")
    private String username;

    @Size(min = 8)
    private String password;

}
