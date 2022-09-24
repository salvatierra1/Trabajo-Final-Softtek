package com.sofftektp.trabajofinal.model;

import com.sofftektp.trabajofinal.auth.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import javax.persistence.*;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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



}
