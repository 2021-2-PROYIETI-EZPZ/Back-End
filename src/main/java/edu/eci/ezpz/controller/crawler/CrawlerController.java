package edu.eci.ezpz.controller.crawler;

import edu.eci.ezpz.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/crawler")
public class CrawlerController {

    @Autowired
    private CrawlerService crawlerService;

    @GetMapping("/{product}")
    public ArrayList<ProductDto> startWebCrawling(@PathVariable String product){
        return crawlerService.startWebCrawling(product);
    }


}
