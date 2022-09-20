package com.sofftektp.trabajofinal.model;

import com.sofftektp.trabajofinal.auth.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "seller")
@SQLDelete(sql = "UPDATE seller SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="deleted")
    private boolean deleted = Boolean.FALSE;
    
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

    @OneToMany
    private Collection<ProductSeller> productSellers;

}
