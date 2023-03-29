package com.eyal.salesboard.Entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter

public enum ApartmentsTypeEnum {
    apartment, twofamily, villa;
    @JsonCreator
    public static ApartmentsTypeEnum create(String value) {
        return ApartmentsTypeEnum.valueOf(value.toLowerCase());
    }
}
