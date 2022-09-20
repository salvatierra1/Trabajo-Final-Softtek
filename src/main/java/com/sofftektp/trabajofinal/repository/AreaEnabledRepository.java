package com.sofftektp.trabajofinal.repository;

import com.sofftektp.trabajofinal.model.AreaEnabled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaEnabledRepository extends JpaRepository<AreaEnabled, Long> {
}
