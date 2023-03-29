package com.eyal.salesboard.Entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ElectricalUseEnum {
    New,Old;

    @JsonCreator
    public static ElectricalUseEnum create(String value) {
        String val = value.substring(0, 1).toUpperCase() + value.substring(1);
        return ElectricalUseEnum.valueOf(val);
    }
}
