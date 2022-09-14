package com.sofftektp.trabajofinal.repository;

import com.sofftektp.trabajofinal.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
