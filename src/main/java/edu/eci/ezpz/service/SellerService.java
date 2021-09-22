package edu.eci.ezpz.service;

import edu.eci.ezpz.controller.seller.SellerDto;
import edu.eci.ezpz.repository.document.Seller;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SellerService {

    Seller createSeller(SellerDto dto) throws IOException;

    Seller updateSeller(SellerDto dto, String email);
}
