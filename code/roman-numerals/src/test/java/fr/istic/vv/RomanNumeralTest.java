package fr.istic.vv;
import net.jqwik.api.*;
import net.jqwik.api.arbitraries.*;

import static org.junit.Assert.assertEquals;

public class RomanNumeralTest {
    @Property
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        return Math.abs(anInteger) >= 0;
    }
    
    @Property
    void isValidRomanNumeral(@ForAll("validRomanNumerals") String numeral) {
        assertEquals(true, RomanNumeralUtils.isValidRomanNumeral(numeral));
    }

    @Property
    void parseRomanNumeral(@ForAll("validRomanNumerals") String numeral) {
        assertEquals(numeral, RomanNumeralUtils.toRomanNumeral(RomanNumeralUtils.parseRomanNumeral(numeral)));
    }

    @Property
    void toRomanNumeral(@ForAll int number) {
        if (number >= 1 && number <= 3999) {
            assertEquals(number, RomanNumeralUtils.parseRomanNumeral(RomanNumeralUtils.toRomanNumeral(number)));
        }
    }

    @Provide
    Arbitrary<String> validRomanNumerals() {
        return Arbitraries.of("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M")
                          .flatMap(s -> Arbitraries.oneOf(s, s + s, s + s + s));
    }

}
