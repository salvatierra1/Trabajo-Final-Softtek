package com.sofftektp.trabajofinal.model;

import com.sofftektp.trabajofinal.auth.model.UserEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserEntity userEntity;

}
