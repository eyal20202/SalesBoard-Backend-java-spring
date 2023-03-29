package com.eyal.salesboard.Service;

import com.eyal.salesboard.Builder.BaseProductBuilder;
import com.eyal.salesboard.Entity.Enums.ProductTypeEnum;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductBuilderFactory {
    @Autowired
    private List<BaseProductBuilder> builderList;

    private static final Map<ProductTypeEnum, BaseProductBuilder> baseProductBuilderMap = new HashMap<>();

    @PostConstruct
    public void initProductsCache() {
        if(builderList!= null && !builderList.isEmpty()) {
           for(BaseProductBuilder productBuilder : builderList) {
                baseProductBuilderMap.put(productBuilder.getProductTypeEnum(), productBuilder);
            }
        }
    }

    public BaseProductBuilder getBuilder(ProductTypeEnum productTypeEnum) {
        BaseProductBuilder baseProductBuilder =  baseProductBuilderMap.get(productTypeEnum);
        return baseProductBuilder;
    }
}
