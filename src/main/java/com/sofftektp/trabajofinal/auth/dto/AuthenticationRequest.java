package com.sofftektp.trabajofinal.auth.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    private String username;
    private String password;

}