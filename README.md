# RomanNumeralConverter
Converts Roman Numerals to Integers

This project is my first attempt at Test Driven Development.
I have included the method stub and the first, most basic test with my initial commit


# About my Algorithm:
I decided to start with a switch statement as my main decision algorithm because in the beginning it seemed like every
character would be treated differently. I built it up from there to look at the previous character so subtractive pairs would
work. Then I added boolean flags so there would be only one V, L, and D. Then I added some counters so X, C, and M would not
be equaled by smaller denominations. The switch statement helps with error checking as if the character does not match any of 
the cases, it just falls to the default and we throw an IllegalArgumentException. My subroutine throws an exception as soon as
it encounters a space, lowercase letter, number, or any other ascii character it is not expecting. The only characters it will
accept is any combination of {I V X L C D M}, assuming it doesn't break any other rule. I used the following page to get more
info about proper Roman Numerals: https://projecteuler.net/about=roman_numerals

