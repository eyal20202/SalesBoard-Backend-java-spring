package com.eyal.salesboard.Entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SaleRentTypeEnum {
    Sale,
    Rent;
    @JsonCreator
    public static SaleRentTypeEnum create(String value) {
        String val = value.substring(0, 1).toUpperCase() + value.substring(1);
        return SaleRentTypeEnum.valueOf(val);
    }
}
