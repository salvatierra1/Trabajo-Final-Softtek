package com.sofftektp.trabajofinal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sofftektp.trabajofinal.auth.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data
@AllArgsConstructor
@Table (name = "manager")
@SQLDelete(sql = "UPDATE manager SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Manager{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

    @OneToMany
    private Collection<ProductBasic> productBasics;

    public Manager(){
        this.productBasics = new ArrayList<>();
    }

}
