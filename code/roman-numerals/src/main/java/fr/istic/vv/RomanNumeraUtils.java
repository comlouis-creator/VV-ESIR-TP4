package fr.istic.vv;

public class RomanNumeraUtils {
    
        public static boolean isValidRomanNumeral(String value) { 
            return value.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
        }
    
        public static int parseRomanNumeral(String numeral) {
            int total = 0;
            int previousValue = 0;

            for (int i = numeral.length() - 1; i >= 0; i--) {
                int currentValue = 0;

                switch (numeral.charAt(i)) {
                    case 'M':
                        currentValue = 1000;
                        break;
                    case 'D':
                        currentValue = 500;
                        break;
                    case 'C':
                        currentValue = 100;
                        break;
                    case 'L':
                        currentValue = 50;
                        break;
                    case 'X':
                        currentValue = 10;
                        break;
                    case 'V':
                        currentValue = 5;
                        break;
                    case 'I':
                        currentValue = 1;
                        break;
             }

          if (currentValue < previousValue) {
              total -= currentValue;
          } else {
              total += currentValue;
          }

          previousValue = currentValue;
        }

    return total;
   }

    
       public static String toRomanNumeral(int number) {
           StringBuilder numeral = new StringBuilder();

           while (number >= 1000) {
               numeral.append("M");
               number -= 1000;
           }

           if (number >= 900) {
               numeral.append("CM");
               number -= 900;
           } else if (number >= 500) {
               numeral.append("D");
               number -= 500;
           } else if (number >= 400) {
               numeral.append("CD");
               number -= 400;
           }

           while (number >= 100) {
               numeral.append("C");
               number -= 100;
           }

           if (number >= 90) {
               numeral.append("XC");
               number -= 90;
           } else if (number >= 50) {
               numeral.append("L");
               number -= 50;
           } else if (number >= 40) {
               numeral.append("XL");
               number -= 40;
           }

           while (number >= 10) {
               numeral.append("X");
               number -= 10;
           }

           if (number >= 9) {
              numeral.append("IX");
              number -= 9;
          } else if (number >= 5) {
              numeral.append("V");
              number -= 5;
          } else if (number >= 4) {
              numeral.append("IV");
              number -= 4;
          }

          while (number >= 1) {
              numeral.append("I");
              number -= 1;
          }

    return numeral.toString();
   }

    
}
