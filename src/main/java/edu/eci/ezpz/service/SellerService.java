package edu.eci.ezpz.service;

import edu.eci.ezpz.controller.seller.SellerDto;
import edu.eci.ezpz.exception.SellerNotFoundException;
import edu.eci.ezpz.repository.document.Product;
import edu.eci.ezpz.repository.document.Seller;
import java.io.IOException;
import java.util.ArrayList;

public interface SellerService {

    public Seller findByEmail(String email) throws SellerNotFoundException;

    Seller createSeller(SellerDto dto) throws IOException;

    Seller updateSeller(SellerDto dto, String email) throws IOException;
}
