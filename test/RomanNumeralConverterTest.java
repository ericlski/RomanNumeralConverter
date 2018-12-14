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

    @Test
    public void subtractTest() {
        int result;
        result = converter.r2i("IV");
        assertEquals(4, result);
        result = converter.r2i("IX");
        assertEquals(9, result);
        result = converter.r2i("XLIX");
        assertEquals(49, result);
        result = converter.r2i("CM");
        assertEquals(900, result);
        result = converter.r2i("CD");
        assertEquals(400, result);
        result = converter.r2i("XC");
        assertEquals(90, result);
        result = converter.r2i("XL");
        assertEquals(40, result);
    }

    @Test
    public void trickyTest() {
        Exception exception = null;
        try {
            converter.r2i("testyboi");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            converter.r2i("XVIImesswiththetestyboi");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            converter.r2i("xvii");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }
}