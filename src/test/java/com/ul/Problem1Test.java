package com.ul;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem1Test {

    private final TlvParser parser = new TlvParser();

    @Test
    void validTag8A() {
        Tlv tag8A = parser.parseTlvFromString("8A023030");
        assertEquals("8A", tag8A.tag);
        assertEquals(2, tag8A.length);
        assertEquals("3030", tag8A.value);
    }

    @Test
    void validTag5A() {
        Tlv tag5A = parser.parseTlvFromString("5A081122334455667788");
        assertEquals("5A", tag5A.tag);
        assertEquals(8, tag5A.length);
        assertEquals("1122334455667788", tag5A.value);
    }

    @Test
    void validTag57() {
        Tlv tag57 = parser.parseTlvFromString("5709374245001741007D24");
        assertEquals("57", tag57.tag);
        assertEquals(9, tag57.length);
        assertEquals("374245001741007D24", tag57.value);    }
}
