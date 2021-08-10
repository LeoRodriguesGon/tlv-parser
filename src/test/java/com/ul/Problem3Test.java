package com.ul;

import static com.ul.Tlv.INVALID_TLV;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem3Test {

    private final TlvParser parser = new TlvParser();

    @Test
    void emptyInput() {
        Tlv tlv = parser.parseTlvFromString("");
        assertEquals(INVALID_TLV.tag, tlv.tag);
        assertEquals(INVALID_TLV.length, tlv.length);
        assertEquals(INVALID_TLV.value, tlv.value);
    }

    @Test
    void whitespaceInput() {
        Tlv tlv = parser.parseTlvFromString("     ");
        assertEquals(INVALID_TLV.tag, tlv.tag);
        assertEquals(INVALID_TLV.length, tlv.length);
        assertEquals(INVALID_TLV.value, tlv.value);
    }

    @Test
    void inputDataTooShort() {
        Tlv tlv = parser.parseTlvFromString("8A02");
        assertEquals(INVALID_TLV.tag, tlv.tag);
        assertEquals(INVALID_TLV.length, tlv.length);
        assertEquals(INVALID_TLV.value, tlv.value);
    }

    @Test
    void inputDataTooShortWithWhitespace() {
        Tlv tlv = parser.parseTlvFromString(" 8A 02    ");
        assertEquals(INVALID_TLV.tag, tlv.tag);
        assertEquals(INVALID_TLV.length, tlv.length);
        assertEquals(INVALID_TLV.value, tlv.value);
    }

    @Test
    void inputDataTooLong() {
        Tlv tlv = parser.parseTlvFromString("8A02010203");
        assertEquals(INVALID_TLV.tag, tlv.tag);
        assertEquals(INVALID_TLV.length, tlv.length);
        assertEquals(INVALID_TLV.value, tlv.value);
    }

    @Test
    void inputDataTooLongWithWhitespace() {
        Tlv tlv = parser.parseTlvFromString(" 8A  02 0 1 02 0  3  ");
        assertEquals(INVALID_TLV.tag, tlv.tag);
        assertEquals(INVALID_TLV.length, tlv.length);
        assertEquals(INVALID_TLV.value, tlv.value);
    }

    @Test
    void inputDataInvalid() {
        Tlv tlv = parser.parseTlvFromString("RandomString,NotATlv");
        assertEquals(INVALID_TLV.tag, tlv.tag);
        assertEquals(INVALID_TLV.length, tlv.length);
        assertEquals(INVALID_TLV.value, tlv.value);
    }
}