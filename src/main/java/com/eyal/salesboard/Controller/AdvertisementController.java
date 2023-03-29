package com.eyal.salesboard.Controller;

import com.eyal.salesboard.Entity.Dto.*;
import com.eyal.salesboard.Entity.Enums.ProductTypeEnum;
import com.eyal.salesboard.Service.AdvertisementService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class AdvertisementController {
    @Autowired
    AdvertisementService advertisementService;
    Gson gson = new Gson();

    @GetMapping("/hello")
    public String helloToAppSales() {
        return "helloToAppSales";
    }

    @GetMapping("/getSizePost")
    public String getSizeAdvertisement() {
        return advertisementService.getAdvertisements().size()+"";
    }

    @GetMapping("/getPosts")
    public String getAdvertisements() {
        return advertisementService.getAdvertisements().stream().map(Object::toString).collect(Collectors.joining(", \n"));
    }

    @PostMapping("/addPost")
    public String addAdvertisement(@RequestBody BaseProduct baseProduct) {
        advertisementService.addAdvertisement(baseProduct);
        return getAdvertisements();
    }
    @DeleteMapping("/removeAdvertisement")
    public String removeAdvertisement(@RequestBody BaseProduct baseProduct) {
        advertisementService.removeAdvertisement(baseProduct.getId());
        return getAdvertisements();
    }
    @PutMapping("/editAdvertisement")
    public String editAdvertisement(@RequestBody BaseProduct baseProduct) {
        advertisementService.editAdvertisement(baseProduct);
        return getAdvertisements();
    }
    @PutMapping("/jumpAdvertisement")
    public String jumpAdvertisement(@RequestBody BaseProduct baseProduct) {
        advertisementService.jumpAdvertisement(baseProduct);
        return getAdvertisements();
    }
    @GetMapping("/filterByProductType/{productTypeEnum}")
    public String filterByProductType(@PathVariable ProductTypeEnum productTypeEnum) {
        return gson.toJson(advertisementService.filterByProductType(productTypeEnum));
    }
    @GetMapping("/filterByCost/{cost}")
    public String filterByCost(@PathVariable int cost) {
        return gson.toJson(advertisementService.filterByCost(cost));
    }
}
