package com.sofftektp.trabajofinal.repository;

import com.sofftektp.trabajofinal.model.PermittedCustomization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermittedCustomizationRepository extends JpaRepository<PermittedCustomization, Long> {
}
