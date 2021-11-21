package edu.eci.ezpz.service;

import edu.eci.ezpz.controller.crawler.ProductDto;

import java.util.ArrayList;

public interface CrawlerService {

    public ArrayList<ProductDto> startWebCrawling(String product);

}
