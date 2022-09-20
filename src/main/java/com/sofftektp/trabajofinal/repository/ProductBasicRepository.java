package com.sofftektp.trabajofinal.repository;

import com.sofftektp.trabajofinal.model.ProductBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBasicRepository extends JpaRepository<ProductBasic, Long> {
}
