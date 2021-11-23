package edu.eci.ezpz.service.impl;

import edu.eci.ezpz.controller.seller.SellerDto;
import edu.eci.ezpz.exception.SellerNotFoundException;
import edu.eci.ezpz.repository.SellerRepository;
import edu.eci.ezpz.repository.document.Seller;
import edu.eci.ezpz.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller findByEmail(String email) throws SellerNotFoundException
    {
        Seller seller = null;
        Optional<Seller> optionalSeller = sellerRepository.findByEmail(email);
        if(optionalSeller.isPresent()) seller = optionalSeller.get();
        else throw new SellerNotFoundException();
        return seller;
    }

    @Override
    public Seller createSeller(SellerDto dto) throws IOException {
        return sellerRepository.save(new Seller(dto.getEmail(), dto.getName(), dto.getUsername(), dto.getPassword(), dto.getLinkPage()));
    }

    @Override
    public Seller updateSeller(SellerDto dto, String email) throws IOException {
        if(sellerRepository.findById(email).isPresent()){
            Seller seller = sellerRepository.findById(email).get();
            sellerRepository.save(seller);
            return seller;
        }
        return null;
    }

}
