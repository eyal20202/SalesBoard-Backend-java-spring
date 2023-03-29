package com.eyal.salesboard.Utils;


public class CountId {

    private static Integer counterProduct = 0;
    private static Integer counterPost = 0;

    private CountId() {
    }
    public static Integer getInstanceProduct() {
        return ++counterProduct;
    }
    public static Integer getInstancePost() {
        return ++counterPost;
    }
}

