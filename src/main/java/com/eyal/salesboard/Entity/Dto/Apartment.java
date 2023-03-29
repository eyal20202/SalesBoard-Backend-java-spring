package com.eyal.salesboard.Entity.Dto;

import com.eyal.salesboard.Entity.Enums.MyStatusEnum;
import com.eyal.salesboard.Entity.Enums.ProductTypeEnum;
import com.eyal.salesboard.Entity.Enums.SaleRentTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class Apartment implements BaseProduct {
    Integer SizeSquareMeters;
    Integer roomNumber;
    SaleRentTypeEnum SaleRent;
    int id;
    String name;
    String description;
    double price;
    String publisherId; //which seller post it

    MyStatusEnum statusEnum; //active / expired
    SaleRentTypeEnum saleRentTypeEnum; // type post for sale or rent
    ProductTypeEnum productTypeEnum;
    String image;

    public Apartment(Integer sizeSquareMeters, Integer roomNumber, SaleRentTypeEnum saleRent, String name, String description, double price, String publisherId, MyStatusEnum status, SaleRentTypeEnum saleRentTypeEnum, String image) {
        SizeSquareMeters = sizeSquareMeters;
        this.roomNumber = roomNumber;
        SaleRent = saleRent;
        this.name = name;
        this.description = description;
        this.price = price;
        this.publisherId = publisherId;
        this.statusEnum = status;
        this.saleRentTypeEnum = saleRentTypeEnum;
        this.image = image;
    }
    public Apartment(){
        productTypeEnum = ProductTypeEnum.Apartments;
    }
    public ProductTypeEnum getProductTypeEnum() {
        return ProductTypeEnum.Apartments;
    }
}
