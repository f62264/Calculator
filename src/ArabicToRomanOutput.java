public class ArabicToRomanOutput {

    static int numbers[]  = {1, 4, 5, 9, 10, 40, 50, 90, 100, 500};
    static String letters[]  = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "D"};


    public String arabicToRoman(int arabic) {

        String romanValue = "";
        int num = arabic;
        while (num > 0) {
            for (int i = 0; i < numbers.length; i++) {
                if (num < numbers[i]) {
                    num -= numbers[i - 1];
                    romanValue += letters[i - 1];
                    break;
                }
            }
        }
        return romanValue;
    }
}