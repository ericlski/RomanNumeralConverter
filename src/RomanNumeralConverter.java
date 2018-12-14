public class RomanNumeralConverter {

    /**
     * Converts a Roman Numeral into an int.
     * <p>
     * Only converts positive Roman Numerals between 1 to 3999.
     * The numeral parameter must be a valid Roman Numeral.
     * Valid numerals include:
     * I=1, V=5, X=10, L=50, C=100, D=500, M=1000
     * IV=4, IX=9, XL=40, XC=90, CD=400, CM=900
     * MCMLXXIV=1974
     * <p>
     * For more on valid/invalid numerals, please see:
     * https://projecteuler.net/about=roman_numerals
     *
     * @param roman The string numeral to be converted.
     * @return An integer translation of the numeral parameter.
     * @throws IllegalArgumentException when roman argument cannot be
     *                                  converted per the contract
     */
    public static int r2i(String roman) throws IllegalArgumentException {
        int result = 0;
        // Conversion code
        for (char x: roman.toCharArray()) {
            switch (x){
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default:
                    throw new IllegalArgumentException("Undefined Roman Numeral Given");
            }
        }
        return result;
    }

}