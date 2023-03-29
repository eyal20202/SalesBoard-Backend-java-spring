package com.eyal.salesboard.Builder;

import com.eyal.salesboard.Entity.Dto.BaseProduct;
import com.eyal.salesboard.Entity.Enums.ProductTypeEnum;
import com.eyal.salesboard.Utils.CountId;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseProductBuilder {

    // the basic setter
    public final void setBaseProductBuilder(BaseProduct baseProduct, BaseProduct newBaseProduct) {
        newBaseProduct.setProductTypeEnum(baseProduct.getProductTypeEnum());
        newBaseProduct.setDescription(baseProduct.getDescription());
        newBaseProduct.setImage(baseProduct.getImage());
        newBaseProduct.setPrice(baseProduct.getPrice());
        newBaseProduct.setPublisherId(baseProduct.getPublisherId());
        newBaseProduct.setId(baseProduct.getId());
        newBaseProduct.setSaleRentTypeEnum(baseProduct.getSaleRentTypeEnum());
        setExtendProductBuilder(baseProduct,newBaseProduct);
    }

    public abstract ProductTypeEnum getProductTypeEnum();

    public BaseProduct newBuild(BaseProduct baseProduct){ // add here validation
        baseProduct.setId(CountId.getInstanceProduct());
        setBaseProductBuilder(baseProduct,getBaseProduct());
        return getBaseProduct();
    }
    abstract BaseProduct getBaseProduct();

    abstract BaseProduct setExtendProductBuilder(BaseProduct baseProduct, BaseProduct newBaseProduct);

}
