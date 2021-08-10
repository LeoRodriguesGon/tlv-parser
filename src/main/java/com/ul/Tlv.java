package com.ul;

public class Tlv {

    public static final Tlv INVALID_TLV = new Tlv("Invalid Tlv", -1, "Invalid Tlv");

    String tag;
    int length;
    String value;

    public Tlv() {

    }

    public Tlv(String tag, int length, String value) {
        this.tag = tag;
        this.length = length;
        this.value = value;
    }
}
