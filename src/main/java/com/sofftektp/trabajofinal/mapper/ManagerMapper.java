package com.sofftektp.trabajofinal.mapper;

import com.sofftektp.trabajofinal.dto.ManagerDTO;
import com.sofftektp.trabajofinal.model.Manager;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {

    public ManagerDTO managerEntity2Dto(Manager manager) {
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setId(manager.getId());
        managerDTO.setName(manager.getUserEntity().getName());
        managerDTO.setUsername(manager.getUserEntity().getUsername());
        return managerDTO;
    }
}
