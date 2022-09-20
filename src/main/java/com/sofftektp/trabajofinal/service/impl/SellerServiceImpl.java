package com.sofftektp.trabajofinal.service.impl;

import com.sofftektp.trabajofinal.dto.SellerDTO;
import com.sofftektp.trabajofinal.exception.NotFoundException;
import com.sofftektp.trabajofinal.mapper.SellerMapper;
import com.sofftektp.trabajofinal.model.Seller;
import com.sofftektp.trabajofinal.repository.SellerRepository;
import com.sofftektp.trabajofinal.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public SellerDTO getByIdSeller(Long id) {
        Optional<Seller> entity = this.sellerRepository.findById(id);
        if (entity.isPresent()){
            return sellerMapper.EntityToDto(entity.get());
        }
        throw new NotFoundException("No existe el id: " + id);

    }

    @Override
    public void delete(Long id) {
        if(!sellerRepository.existsById(id)){
            throw new NotFoundException("No existe el id: " + id);
        }else {
            sellerRepository.deleteById(id);
        }
    }
}
