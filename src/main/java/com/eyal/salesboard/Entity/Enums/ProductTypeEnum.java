package com.eyal.salesboard.Entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ProductTypeEnum {
    Electrical,Car,Apartments;

    @JsonCreator
    public static ProductTypeEnum create(String value) {
        String val = value.substring(0, 1).toUpperCase() + value.substring(1);
        return ProductTypeEnum.valueOf(val);
    }
}
