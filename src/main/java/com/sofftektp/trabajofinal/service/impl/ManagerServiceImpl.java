package com.sofftektp.trabajofinal.service.impl;

import com.sofftektp.trabajofinal.dto.ManagerDTO;
import com.sofftektp.trabajofinal.mapper.ManagerMapper;
import com.sofftektp.trabajofinal.model.Manager;
import com.sofftektp.trabajofinal.repository.ManagerRepository;
import com.sofftektp.trabajofinal.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public ManagerDTO getByIdManager(Long id) {
        Optional<Manager> entity = this.managerRepository.findById(id);
        return managerMapper.managerEntity2Dto(entity.get());
    }
}
