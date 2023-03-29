package com.eyal.salesboard.Configuration;

import com.eyal.salesboard.Entity.Dto.*;
import com.eyal.salesboard.Entity.Enums.*;
import com.eyal.salesboard.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CustomConfiguration {

    @Autowired
    ProductService productService;

    @Bean
    @Order(1)
    public List<Advertisement> support() {
        List<Advertisement> list = new ArrayList<>();
        list.add(addAdvertisement(new Car("2","toyta yaris",5,"black",15.0,"hello","description",52.52,"publisher", MyStatusEnum.Active, SaleRentTypeEnum.Rent,"image")));
        list.add(addAdvertisement(new Apartment(120,5, SaleRentTypeEnum.Rent,"hello","description",25.25,"publisher", MyStatusEnum.Active, SaleRentTypeEnum.Rent,"image")));
        list.add(addAdvertisement(new Electrical(ElectricalTypeEnum.TV, ElectricalUseEnum.New, "name","hello",25.56,"publisher", MyStatusEnum.Active, SaleRentTypeEnum.Rent,"image")));
        return list;
    }
    private Advertisement addAdvertisement(BaseProduct product) {
        Advertisement advertisement = new Advertisement();
        BaseProduct baseProduct = productService.buildProduct(product);
        advertisement.setProduct(baseProduct);
        advertisement.setId(baseProduct.getId());
        return advertisement;
    }

}
