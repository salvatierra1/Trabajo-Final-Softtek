package com.sofftektp.trabajofinal.model;

import com.sofftektp.trabajofinal.auth.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserEntity userEntity;


}
