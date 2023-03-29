package com.eyal.salesboard.Entity.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Setter
@Component
public class Advertisement {

    BaseProduct product;
    int id;
}
