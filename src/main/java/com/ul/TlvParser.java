package com.ul;

/**
 * The objective is to develop the functionality for a TLV (Tag, Length, Value) parser.
 * For each stage of the assignment, complete the corresponding method of the TlvParser
 */
public class TlvParser {

    /**
     * Returns a com.ul.Tlv parsed from the given input string
     *
     * @param tlvString A Tlv encoded String
     * @return com.ul.Tlv if the input is valid, return Tlv.INVALID_TLV
     */
    Tlv parseTlvFromString(String tlvString) {
        Tlv tlv = new Tlv();
        
        try {
	        String cleanSpace = tlvString.replaceAll(" ", "");
	        tlv.tag = cleanSpace.substring(0,2);
	        tlv.length = Integer.parseInt(cleanSpace.substring(2,4));
	        tlv.value = cleanSpace.substring(4,cleanSpace.length());
	       
	        if(tlv.length != tlv.value.length()/2) {
	        	return Tlv.INVALID_TLV;
	        }
	        
	        return tlv;
        }catch(Exception e) {
        	return Tlv.INVALID_TLV;
        }
        
    }
}

