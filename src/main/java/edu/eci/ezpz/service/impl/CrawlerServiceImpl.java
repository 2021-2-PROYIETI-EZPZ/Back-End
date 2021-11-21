package edu.eci.ezpz.service.impl;

import edu.eci.ezpz.controller.crawler.ProductDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;

@Service
public class CrawlerServiceImpl implements edu.eci.ezpz.service.CrawlerService {


    @Override
    public ArrayList<ProductDto> startWebCrawling(String requestedProduct) {
        ArrayList<ProductDto> products = new ArrayList<>();
        //Mercado libre
        String query = requestedProduct.replace(" ", "-");
        System.out.println("El query: "+query);
        try {
            Document doc =  Jsoup.connect("https://listado.mercadolibre.com.co/"+query).get();
            Elements cards =  doc.select("div.andes-card.andes-card--flat.andes-card--default.ui-search-result.ui-search-result--core.andes-card--padding-default");
            ProductDto product = new ProductDto();
            for (Element e : cards){
                URL url = new URL(e.select("div.slick-slide.slick-active").get(0).child(0).attr("data-src"));
                String encodedImg = getEncodedImage( url );
                String itemUrl = e.select("a.ui-search-link").attr("href");
                String price = e.select("span.price-tag-fraction").get(0).ownText();
                String title = e.select("h2.ui-search-item__title").get(0).ownText();
                String site = "Mercado Libre";
                product.setTitle(title);
                product.setPrice(price);
                product.setSite(site);
                product.setImg(encodedImg);
                product.setUrl(itemUrl);
                products.add(product);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    return products;
    }

    private String getEncodedImage( URL url ){
        InputStream in = null;
        String encodedImg = "";
        try {
            in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1!=(n=in.read(buf)))
            {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();
            encodedImg = Base64.getEncoder().encodeToString(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedImg;
    }


}
