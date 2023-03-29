package com.eyal.salesboard.Entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ElectricalTypeEnum {
    Refrigerator, TV, Computer, SmartPhone, Drone, Amplifier;
    @JsonCreator
    public static ElectricalTypeEnum create(String value) {
        String val = value.substring(0, 1).toUpperCase() + value.substring(1);
        return ElectricalTypeEnum.valueOf(val);
    }
}
