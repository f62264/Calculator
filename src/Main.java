import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(Main.calc(input));
            }
        }

        public static String calc (String input) {
            int result = 0;
            String output = "";

            if(!input.matches("(I{1,3}[VX]?|[VX]|VI{1,3})\\s?[-+*/]\\s?(I{1,3}[VX]?|[VX]|VI{1,3})") &&
                    !input.matches("(10|[1-9])\\s*[-+*/]\s*(10|[1-9])")){
                throw new IllegalArgumentException("throws Exception");
            }
            if (input.matches("^(10|[1-9])\\s*[-+*/]\s*(10|[1-9])$")) {

                    int[] numArr = Arrays.stream(input.split("\\D+")).mapToInt(Integer::parseInt).toArray();

                    if (input.matches("\\d+\\s*\\+\\s*\\d+\\s*")) {
                        result = Arrays.stream(numArr).sum();
                    } else if (input.matches("\\d+\\s*\\-\\s*\\d+\\s*")) {
                        result = numArr[0] - numArr[1];
                    } else if (input.matches("\\d+\\s*\\*\\s*\\d+\\s*")) {
                        result = numArr[0] * numArr[1];
                    } else if (input.matches("\\d+\\s*\\/\\s*\\d+\\s*")) {
                        result = numArr[0] / numArr[1];
                    }
                    output = Integer.toString(result);



                } else if (input.matches("(?:\\b(?:I{1,3}[VX]?|[VX]|VI{1,3})\\s?" +
                    "[-+*/]\\s?(?:I{1,3}[VX]?|[VX]|VI{1,3}))")) {
                String[] romanSplit = input.split("[-+*/]");

                for (int i = 0; i < romanSplit.length; i++) {
                    romanSplit[i] = romanSplit[i].trim();
                    }

                RomanToArabicInput romanInput = new RomanToArabicInput();
                int[] numArrRomanToArabic = new int[romanSplit.length];
                for (int i = 0; i < romanSplit.length; i++) {
                    numArrRomanToArabic[i] = romanInput.romanToArabic(romanSplit[i]);
                    }

                if (input.matches("\\D+\\s*\\+\\s*\\D+\\s*")) {
                    result = Arrays.stream(numArrRomanToArabic).sum();
                    } else if (input.matches("\\D+\\s*\\-\\s*\\D+\\s*")) {
                    result = numArrRomanToArabic[0] - numArrRomanToArabic[1];
                    if(result <= 0){
                    throw new IllegalArgumentException("throws Exception");
                    }
                } else if (input.matches("\\D+\\s*\\*\\s*\\D+\\s*")) {
                    result = numArrRomanToArabic[0] * numArrRomanToArabic[1];
                } else if (input.matches("\\D+\\s*\\/\\s*\\D+\\s*")) {
                    result = numArrRomanToArabic[0] / numArrRomanToArabic[1];
                    }
                ArabicToRomanOutput arabicToRomanOutput = new ArabicToRomanOutput();
                output = arabicToRomanOutput.arabicToRoman(result);
                }
                return output;
            }
    }




