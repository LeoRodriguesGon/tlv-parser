package com.ul;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem2Test {
    private final TlvParser parser = new TlvParser();

    @Test
    void validTag8AWithSpaces() {
        Tlv tag8A = parser.parseTlvFromString("8A 02 30 30");
        assertEquals("8A", tag8A.tag);
        assertEquals(2, tag8A.length);
        assertEquals("3030", tag8A.value);
    }

    @Test
    void validEmptyValue() {
        Tlv emptyTag8A = parser.parseTlvFromString("8A00");
        assertEquals("8A", emptyTag8A.tag);
        assertEquals(0, emptyTag8A.length);
        assertEquals("", emptyTag8A.value);
    }

    @Test
    void validTag5AWithSpaces() {
        Tlv tag5A = parser.parseTlvFromString("5A 08 11 22 33 44 55 66 77 88");
        assertEquals("5A", tag5A.tag);
        assertEquals(8, tag5A.length);
        assertEquals("1122334455667788", tag5A.value);
    }

    @Test
    void validTag5AWithSoManySpaces() {
        Tlv tag5A = parser.parseTlvFromString("5 A 0 8 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8");
        assertEquals("5A", tag5A.tag);
        assertEquals(8, tag5A.length);
        assertEquals("1122334455667788", tag5A.value);
    }

    @Test
    void validEmptyValueWithWhiteSpace() {
        Tlv tag5A = parser.parseTlvFromString("5A 00");
        assertEquals("5A", tag5A.tag);
        assertEquals(0, tag5A.length);
        assertEquals("", tag5A.value);

        Tlv tag8A = parser.parseTlvFromString("8 A 0 0");
        assertEquals("8A", tag8A.tag);
        assertEquals(0, tag8A.length);
        assertEquals("", tag8A.value);
    }

    @Test
    void validValueWithLeadingAndTrailingWhiteSpace() {
        Tlv tag8A = parser.parseTlvFromString(" 8A 02 30 30   ");
        assertEquals("8A", tag8A.tag);
        assertEquals(2, tag8A.length);
        assertEquals("3030", tag8A.value);

        Tlv tag5A = parser.parseTlvFromString("           5A 00");
        assertEquals("5A", tag5A.tag);
        assertEquals(0, tag5A.length);
        assertEquals("", tag5A.value);
    }
}