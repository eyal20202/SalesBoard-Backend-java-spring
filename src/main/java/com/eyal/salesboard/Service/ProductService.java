package com.eyal.salesboard.Service;

import com.eyal.salesboard.Builder.BaseProductBuilder;
import com.eyal.salesboard.Entity.Dto.BaseProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductBuilderFactory productBuilderFactory;

    public BaseProduct buildProduct(BaseProduct baseProduct){
        BaseProductBuilder baseProductBuilder = productBuilderFactory.getBuilder(baseProduct.getProductTypeEnum());
        return baseProductBuilder.newBuild(baseProduct);
    }

    public void updateProduct(BaseProduct baseProduct,BaseProduct newBaseProduct) {
        BaseProductBuilder baseProductBuilder = productBuilderFactory.getBuilder(baseProduct.getProductTypeEnum());
        baseProductBuilder.setBaseProductBuilder(baseProduct, newBaseProduct);
    }
}
