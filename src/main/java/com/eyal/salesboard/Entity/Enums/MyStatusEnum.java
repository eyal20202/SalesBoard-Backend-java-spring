package com.eyal.salesboard.Entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MyStatusEnum {
    Active,
    Expired;
    @JsonCreator
    public static MyStatusEnum create(String value) {
        String val = value.substring(0, 1).toUpperCase() + value.substring(1);
        return MyStatusEnum.valueOf(val);
    }
}
