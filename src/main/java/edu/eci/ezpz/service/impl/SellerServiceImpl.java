package edu.eci.ezpz.service.impl;

import edu.eci.ezpz.controller.seller.SellerDto;
import edu.eci.ezpz.exception.SellerNotFoundException;
import edu.eci.ezpz.repository.SellerRepository;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.repository.document.Product;
import edu.eci.ezpz.repository.document.Seller;
import edu.eci.ezpz.service.SellerService;
import edu.eci.ezpz.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller createSeller(SellerDto dto) throws IOException {
        //MemberShip memberShip = new MemberShip();
        /*
        for(String[] member : Constants.memberships){
            if (member[0].equals(dto.getCurrentMemberShip().getCodeMembership())) {
                memberShip.setActive(dto.getCurrentMemberShip().isActive());
                memberShip.setName(member[1]);
                memberShip.setDescription(member[2]);
            }
        }*/
        File file = new File("./"+dto.getNameFile());
        byte[] data = Base64.getDecoder().decode(dto.getFileHash());

        try (OutputStream stream = new FileOutputStream(file)) {
            stream.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new FileReader(dto.getNameFile()));
        String line = null;
        String nameProduct;
        String priceProduct;
        String descriptionProduct;
        String urlProduct;
        ArrayList<Product> products = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            Product product = new Product();
            String[] values = line.split(",");
            int count = 0;
            for (String str : values) {
                count += 1;
                if (count == 1) {
                    nameProduct = str;
                    product.setNameProduct(nameProduct);
                } else if (count == 2) {
                    priceProduct = str;
                    product.setPriceProduct(priceProduct);
                } else if (count == 3) {
                    descriptionProduct = str;
                    product.setDescriptionProduct(descriptionProduct);
                } else if (count == 4) {
                    urlProduct = str;
                    product.setUrlProduct(urlProduct);
                }
            }
            products.add(product);
        }
        products.remove(0);
        br.close();
        file.delete();
        return sellerRepository.save(new Seller(dto.getEmail(), dto.getName(), dto.getUsername(), dto.getPassword(), dto.getLinkPage(), products));
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
