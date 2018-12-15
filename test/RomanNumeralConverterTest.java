import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralConverterTest {

    @Test
    void basicTest() {
        int result;
        result = RomanNumeralConverter.r2i("I");
        assertEquals(1, result);
        result = RomanNumeralConverter.r2i("V");
        assertEquals(5, result);
        result = RomanNumeralConverter.r2i("X");
        assertEquals(10, result);
        result = RomanNumeralConverter.r2i("L");
        assertEquals(50, result);
        result = RomanNumeralConverter.r2i("C");
        assertEquals(100, result);
        result = RomanNumeralConverter.r2i("D");
        assertEquals(500, result);
        result = RomanNumeralConverter.r2i("M");
        assertEquals(1000, result);
    }

    @Test
    void subtractTest() {
        int result;
        result = RomanNumeralConverter.r2i("IV");
        assertEquals(4, result);
        result = RomanNumeralConverter.r2i("IX");
        assertEquals(9, result);
        result = RomanNumeralConverter.r2i("XLIX");
        assertEquals(49, result);
        result = RomanNumeralConverter.r2i("CM");
        assertEquals(900, result);
        result = RomanNumeralConverter.r2i("CD");
        assertEquals(400, result);
        result = RomanNumeralConverter.r2i("XC");
        assertEquals(90, result);
        result = RomanNumeralConverter.r2i("XL");
        assertEquals(40, result);
    }

    @Test
    void trickyTest() {
        Exception exception = null;
        try {
            RomanNumeralConverter.r2i("testyboi");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            RomanNumeralConverter.r2i("XVIImesswiththetestyboi");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            RomanNumeralConverter.r2i("xvii");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            RomanNumeralConverter.r2i("XV II");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }

    @Test
    void complicatedTest() {
        int result;
        result = RomanNumeralConverter.r2i("MCMLXXIV");
        assertEquals(1974, result);
        result = RomanNumeralConverter.r2i("XXXXIIIIIIIII");
        assertEquals(49, result);
        result = RomanNumeralConverter.r2i("XXXXVIIII");
        assertEquals(49, result);
        result = RomanNumeralConverter.r2i("XXXXIX");
        assertEquals(49, result);
        result = RomanNumeralConverter.r2i("XLIIIIIIIII");
        assertEquals(49, result);
        result = RomanNumeralConverter.r2i("XLVIIII");
        assertEquals(49, result);
        Exception exception = null;
        try {
            RomanNumeralConverter.r2i("IL");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }

    @Test
    void illegalDoubles () {
        Exception exception = null;
        try {
            RomanNumeralConverter.r2i("VV");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            RomanNumeralConverter.r2i("LL");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            RomanNumeralConverter.r2i("DD");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }

    @Test
    void tooManyLettersInARow() {
        Exception exception = null;
        try {
            RomanNumeralConverter.r2i("IIIIIIIIII");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            RomanNumeralConverter.r2i("XXXXXXXXXX");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            RomanNumeralConverter.r2i("CCCCCCCCCC");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }

    @Test
    void testAscendingOrder() {
        Exception exception = null;
        try {
            RomanNumeralConverter.r2i("IIIVXXX");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            RomanNumeralConverter.r2i("IICDM");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            RomanNumeralConverter.r2i("ICDM");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }

}