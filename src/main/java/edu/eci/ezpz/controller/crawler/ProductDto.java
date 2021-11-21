package edu.eci.ezpz.controller.crawler;

public class ProductDto {

    private String title;
    private String price;
    private String url;
    private String img;
    private String site;

    public ProductDto() { }

    public ProductDto(String title, String price, String url, String img, String site) {
        this.title = title;
        this.price = price;
        this.url = url;
        this.img = img;
        this.site = site;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public String getImg() {
        return img;
    }

    public String getSite() {
        return site;
    }
}
