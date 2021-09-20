package edu.eci.ezpz.service;

import edu.eci.ezpz.controller.seller.SellerDto;
import edu.eci.ezpz.repository.document.Seller;

public interface SellerService {

    Seller createSeller(SellerDto dto);

}
