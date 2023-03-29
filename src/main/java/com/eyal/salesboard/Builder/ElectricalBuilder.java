package com.eyal.salesboard.Builder;

import com.eyal.salesboard.Entity.Dto.BaseProduct;
import com.eyal.salesboard.Entity.Dto.Electrical;
import com.eyal.salesboard.Entity.Enums.ProductTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElectricalBuilder extends BaseProductBuilder {
    @Autowired
    Electrical electrical;

    @Override
    public ProductTypeEnum getProductTypeEnum() {
        return ProductTypeEnum.Electrical;
    }

    @Override
    public BaseProduct getBaseProduct() {
        return electrical;
    }

    @Override
    BaseProduct setExtendProductBuilder(BaseProduct baseProduct, BaseProduct newBaseProduct) {
        Electrical tempElectrical = (Electrical) baseProduct;
        Electrical electrical = (Electrical) newBaseProduct;
        electrical.setElectricalTypeEnum(tempElectrical.getElectricalTypeEnum());
        electrical.setElectricalUseEnum(tempElectrical.getElectricalUseEnum());
        return electrical;
    }
}
