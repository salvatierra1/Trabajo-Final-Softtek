package com.sofftektp.trabajofinal.repository;

import com.sofftektp.trabajofinal.auth.model.UserEntity;
import com.sofftektp.trabajofinal.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller findByUserEntity(UserEntity user);
}
