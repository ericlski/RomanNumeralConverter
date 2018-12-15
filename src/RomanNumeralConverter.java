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
    static int r2i(String roman) throws IllegalArgumentException {
        int result = 0;
        char previousChar = 0;
        boolean vFlag = false;
        boolean lFlag = false;
        boolean dFlag = false;
        int numI = 0;
        int numX = 0;
        int numC = 0;
        // Conversion code
        for (char x: roman.toCharArray()) {
            switch (x){
                case 'I':
                    if (numI == 9) {
                        throw new IllegalArgumentException("Can't have more than 10 I's");
                    }
                    result += 1;
                    numI++;
                    break;

                case 'V':
                    if (vFlag)
                    {
                        throw new IllegalArgumentException("Can't have more than one 'V'");
                    }
                    vFlag = true;
                    if (previousChar == 'I') {
                        if (numI > 1) {
                            throw new IllegalArgumentException("Can't be in ascending order");
                        }
                        // need to remove two as one was already added to result in the previous run thru the loop
                        result -= 2;
                    }
                    result += 5;
                    break;

                case 'X':
                    if (previousChar == 'I') {
                        if (numI > 1) {
                            throw new IllegalArgumentException("Can't be in ascending order");
                        }
                        // need to remove two as one was already added to result in the previous run thru the loop
                        result -= 2;
                    }
                    if (numX == 9) {
                        throw new IllegalArgumentException("Can't have more than 10 X's");
                    }
                    result += 10;
                    numX++;
                    break;

                case 'L':
                    if (lFlag)
                    {
                        throw new IllegalArgumentException("Can't have more than one 'L'");
                    }
                    lFlag = true;
                    if (previousChar == 'X') {
                        if (numX > 1) {
                            throw new IllegalArgumentException("Can't be in ascending order");
                        }
                        // need to remove twenty as ten was already added to result in the previous run thru the loop
                        result -= 20;
                    }
                    else if (previousChar == 'I') {
                        throw new IllegalArgumentException("'I' can't come before 'L'");
                    }
                    result += 50;
                    break;

                case 'C':
                    if (numC == 9) {
                        throw new IllegalArgumentException("Can't have more than 10 C's");
                    }
                    if (previousChar == 'X') {
                        if (numX > 1) {
                            throw new IllegalArgumentException("Can't be in ascending order");
                        }
                        // need to remove twenty as ten was already added to result in the previous run thru the loop
                        result -= 20;
                    }
                    else if (previousChar == 'I') {
                        throw new IllegalArgumentException("'I' can't come before 'C'");
                    }
                    result += 100;
                    numC++;
                    break;

                case 'D':
                    if (dFlag)
                    {
                        throw new IllegalArgumentException("Can't have more than one 'D'");
                    }
                    dFlag = true;
                    if (previousChar == 'C') {
                        if (numC > 1) {
                            throw new IllegalArgumentException("Can't be in ascending order");
                        }
                        // need to remove 200 as 100 was already added to result in the previous run thru the loop
                        result -= 200;
                    }
                    else if (previousChar == 'I') {
                        throw new IllegalArgumentException("'I' can't come before 'D'");
                    }
                    result += 500;
                    break;

                case 'M':
                    if (previousChar == 'C') {
                        if (numC > 1) {
                            throw new IllegalArgumentException("Can't be in ascending order");
                        }
                        // need to remove 200 as 100 was already added to result in the previous run thru the loop
                        result -= 200;
                    }
                    else if (previousChar == 'I') {
                        throw new IllegalArgumentException("'I' can't come before 'M'");
                    }
                    result += 1000;
                    break;

                default:
                    throw new IllegalArgumentException("Undefined Roman Numeral Given");
            }
            previousChar = x;
        }
        return result;
    }

}