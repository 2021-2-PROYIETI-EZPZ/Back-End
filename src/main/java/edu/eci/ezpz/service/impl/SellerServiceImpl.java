package edu.eci.ezpz.service.impl;

import edu.eci.ezpz.controller.seller.SellerDto;
import edu.eci.ezpz.exception.ClientNotFoundException;
import edu.eci.ezpz.exception.ProductoNotFoundException;
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
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller createSeller(SellerDto dto) throws IOException {
        ArrayList<Product> products = convertToArray(dto);
        return sellerRepository.save(new Seller(dto.getEmail(), dto.getName(), dto.getUsername(), dto.getPassword(), dto.getLinkPage(), products));
    }

    public ArrayList<Product> convertToArray(SellerDto dto) throws IOException {
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
        String idProduct;
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
                    idProduct = str;
                    product.setIdProduct(idProduct);
                } else if (count == 2) {
                    nameProduct = str;
                    product.setNameProduct(nameProduct);
                } else if (count == 3) {
                    priceProduct = str;
                    product.setPriceProduct(priceProduct);
                } else if (count == 4) {
                    descriptionProduct = str;
                    product.setDescriptionProduct(descriptionProduct);
                } else if (count == 5) {
                    urlProduct = str;
                    product.setUrlProduct(urlProduct);
                }
            }
            products.add(product);
        }
        products.remove(0);
        br.close();
        file.delete();

        return products;
    }

    @Override
    public Seller updateSeller(SellerDto dto, String email) throws IOException {
        if(sellerRepository.findById(email).isPresent()){
            Seller seller = sellerRepository.findById(email).get();
            ArrayList<Product> products = convertToArray(dto);
            seller.update(dto, products);
            sellerRepository.save(seller);
            return seller;
        }
        return null;
    }

    @Override
    public boolean deleteSeller(String email){
        boolean sellDeleted = sellerRepository.existsById( email );
        if( sellDeleted ){
            sellerRepository.deleteById( email ); }
        else{
            throw new SellerNotFoundException();}
        return sellDeleted;

    }

    @Override
    public boolean deleteProductSeller(String email, String id) {
        System.out.println("F");
        Optional<Seller> seller = sellerRepository.findByEmail(email);
        if (seller.isPresent()) {
            deleteThisProduct(seller.get(), id);
        }
        else{
            throw new SellerNotFoundException();
        }
        return true;
    }

    private void deleteThisProduct(Seller seller,String idProduct){
        boolean exception= false;
        ArrayList<Product> products= seller.getProduct();
        int count=0;
        for (Product p : products){
            if(p.getIdProduct().equals(idProduct)){
                products.remove(count);
                exception= true;
                break;
            }
            count++;
        }
        if(!exception){
            throw new ProductoNotFoundException();
        }
        seller.setProduct(products);
        sellerRepository.save(seller);
    }

    @Override
    public ArrayList<Product> getProductsByEmail(String email) throws IOException {
        Seller seller = sellerRepository.findById(email).get();
        if(sellerRepository.findById(email).isPresent()){
            ArrayList<Product> products;
            products = seller.getProduct();
            return products;
        }
        return null;
    }


}
