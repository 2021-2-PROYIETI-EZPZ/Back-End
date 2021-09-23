package edu.eci.ezpz.service;

import edu.eci.ezpz.controller.seller.SellerDto;
import edu.eci.ezpz.repository.document.Product;
import edu.eci.ezpz.repository.document.Seller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface SellerService {

    Seller createSeller(SellerDto dto) throws IOException;

    Seller updateSeller(SellerDto dto, String email) throws IOException;

    public boolean deleteSeller( String email);

    boolean deleteProductSeller(String email, String id) throws IOException;

    ArrayList<Product> getProductsByEmail(String email) throws IOException;

}
