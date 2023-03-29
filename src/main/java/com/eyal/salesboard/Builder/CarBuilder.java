package com.eyal.salesboard.Builder;

import com.eyal.salesboard.Entity.Dto.BaseProduct;
import com.eyal.salesboard.Entity.Dto.Car;
import com.eyal.salesboard.Entity.Enums.ProductTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarBuilder extends BaseProductBuilder{
    @Autowired
    Car car;

    @Override
    public ProductTypeEnum getProductTypeEnum() {
        return ProductTypeEnum.Car;
    }

    @Override
    public BaseProduct getBaseProduct() {
        return car;
    }

    @Override
    BaseProduct setExtendProductBuilder(BaseProduct baseProduct, BaseProduct newBaseProduct) {
        Car tempCar = (Car) baseProduct;
        Car car = (Car) newBaseProduct;
        car.setYearOfManufacture(tempCar.getYearOfManufacture());
        car.setModel(tempCar.getModel());
        car.setColor(tempCar.getColor());
        car.setKm(tempCar.getKm());
        return car;
    }
}
