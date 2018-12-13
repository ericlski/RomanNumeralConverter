import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralConverterTest {

    RomanNumeralConverter converter = new RomanNumeralConverter();

    @Test
    public void basicTest() {
        int result;
        result = converter.r2i("I");
        assertEquals(1, result);
        result = converter.r2i("V");
        assertEquals(5, result);
        result = converter.r2i("X");
        assertEquals(10, result);
        result = converter.r2i("L");
        assertEquals(50, result);
        result = converter.r2i("C");
        assertEquals(100, result);
        result = converter.r2i("D");
        assertEquals(500, result);
        result = converter.r2i("M");
        assertEquals(1000, result);
    }
}