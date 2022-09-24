package com.sofftektp.trabajofinal.repository;

import com.sofftektp.trabajofinal.model.Customization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizationRepository extends JpaRepository<Customization, Long> {
}
