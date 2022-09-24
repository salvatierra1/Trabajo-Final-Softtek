package com.sofftektp.trabajofinal.repository;

import com.sofftektp.trabajofinal.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaSellerRepository extends JpaRepository<Area, Long> {
}
