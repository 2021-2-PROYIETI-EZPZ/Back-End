package edu.eci.ezpz.service.impl;

import edu.eci.ezpz.controller.seller.SellerDto;
import edu.eci.ezpz.exception.SellerNotFoundException;
import edu.eci.ezpz.repository.SellerRepository;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.repository.document.Seller;
import edu.eci.ezpz.service.SellerService;
import edu.eci.ezpz.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller createSeller(SellerDto dto) {
        MemberShip memberShip = new MemberShip();
        for(String[] member : Constants.memberships){
            if (member[0].equals(dto.getCurrentMemberShip().getCodeMembership())) {
                memberShip.setActive(dto.getCurrentMemberShip().isActive());
                memberShip.setName(member[1]);
                memberShip.setDescription(member[2]);
            }
        }
        return sellerRepository.save(new Seller(dto.getEmail(), dto.getName(), dto.getUsername(), dto.getPassword(), dto.getLinkPage(), memberShip));
    }

    @Override
    public Seller updateSeller(SellerDto dto, String email) {

        if(sellerRepository.findById(email).isPresent()){
            Seller seller = sellerRepository.findById(email).get();
            seller.update(dto);
            sellerRepository.save(seller);
            return seller;
        }
        return null;
    }

}
