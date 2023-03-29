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
public class Car implements BaseProduct {
    String manufacturer;
    String  model;
    int yearOfManufacture;
    String color;
    double km;
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
        return ProductTypeEnum.Car;
    }

    public Car(String manufacturer, String model, int yearOfManufacture, String color, double km,
               String name, String description, double price, String publisherId, MyStatusEnum status,
               SaleRentTypeEnum saleRentTypeEnum, String image) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.km = km;
//        this.id = CountId.getInstance();
        this.name = name;
        this.description = description;
        this.price = price;
        this.publisherId = publisherId;
        this.statusEnum = status;
        this.saleRentTypeEnum = saleRentTypeEnum;
        this.image = image;
    }
//
    public Car(){
        productTypeEnum = ProductTypeEnum.Car;
    }

}
