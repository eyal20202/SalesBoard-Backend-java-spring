package com.eyal.salesboard.Entity.Dto;

import com.eyal.salesboard.Entity.Enums.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class Electrical implements BaseProduct {
    ElectricalTypeEnum electricalTypeEnum;
    ElectricalUseEnum electricalUseEnum;
    int id;
    String name;
    String description;
    double price;
    String publisherId; //which seller post it
    MyStatusEnum statusEnum; //active / expired
    SaleRentTypeEnum saleRentTypeEnum; // type post for sale or rent
    ProductTypeEnum productTypeEnum;
    String image;

    public ProductTypeEnum getProductTypeEnum() {
        return ProductTypeEnum.Electrical;
    }

    public Electrical(ElectricalTypeEnum electricalTypeEnum, ElectricalUseEnum electricalUseEnum,
                      String name, String description, double price,
                      String publisherId, MyStatusEnum status, SaleRentTypeEnum saleRentTypeEnum,
                      String image) {
        this.electricalTypeEnum = electricalTypeEnum;
        this.electricalUseEnum = electricalUseEnum;
        this.name = name;
        this.description = description;
        this.price = price;
        this.publisherId = publisherId;
        this.statusEnum = status;
        this.saleRentTypeEnum = saleRentTypeEnum;
        this.image = image;
    }

    public Electrical(){
        productTypeEnum = ProductTypeEnum.Electrical;
    }
}
