package com.eyal.salesboard.Entity.Dto;

import com.eyal.salesboard.Entity.Enums.MyStatusEnum;
import com.eyal.salesboard.Entity.Enums.ProductTypeEnum;
import com.eyal.salesboard.Entity.Enums.SaleRentTypeEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "productType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "Car"),
        @JsonSubTypes.Type(value = Apartment.class, name = "Apartments"),
        @JsonSubTypes.Type(value = Electrical.class, name = "Electrical")
})
public interface BaseProduct extends Serializable {

    int getId();

    String getName();

    String getDescription();

    double getPrice();

    String getPublisherId();

    MyStatusEnum getStatusEnum();

    SaleRentTypeEnum getSaleRentTypeEnum();

    ProductTypeEnum getProductTypeEnum();

    String getImage();

    void setId(int id);

    void setName(String name);

    void setDescription(String description);

    void setPrice(double price);

    void setPublisherId(String publisherId);

    void setStatusEnum(MyStatusEnum statusEnum);

    void setSaleRentTypeEnum(SaleRentTypeEnum saleRentTypeEnum);

    void setProductTypeEnum(ProductTypeEnum productTypeEnum);

    void setImage(String image);
}
