package com.sofftektp.trabajofinal.repository;

import com.sofftektp.trabajofinal.model.ProductSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSellerRepository extends JpaRepository<ProductSeller, Long> {
}
