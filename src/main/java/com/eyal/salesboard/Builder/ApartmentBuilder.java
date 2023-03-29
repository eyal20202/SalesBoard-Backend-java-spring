package com.eyal.salesboard.Builder;

import com.eyal.salesboard.Entity.Dto.Apartment;
import com.eyal.salesboard.Entity.Dto.BaseProduct;
import com.eyal.salesboard.Entity.Enums.ProductTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApartmentBuilder extends BaseProductBuilder{
    @Autowired
    Apartment apartment;

    @Override
    public ProductTypeEnum getProductTypeEnum() {
        return ProductTypeEnum.Apartments;
    }

    BaseProduct setExtendProductBuilder(BaseProduct baseProduct, BaseProduct newBaseProduct){
        Apartment tempApartment = (Apartment)baseProduct;
        Apartment apartment = (Apartment)newBaseProduct;
        apartment.setSizeSquareMeters(tempApartment.getSizeSquareMeters());
        apartment.setRoomNumber(tempApartment.getRoomNumber());
        apartment.setSaleRent(tempApartment.getSaleRent());
        apartment.setSizeSquareMeters(tempApartment.getSizeSquareMeters());
        return apartment;
    }

    @Override
    public BaseProduct getBaseProduct() {
        return apartment;
    }
}
