import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseConverter {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            String command = scanner.nextLine();
            if (command.matches("/exit")) {
                break;
            } else {
                String[] strings = command.split(" ");
                BigDecimal sourceBase = BigDecimal.valueOf(Long.parseLong(strings[0]));
                int targetBase = Integer.parseInt(strings[1]);
                do {
                    System.out.println("Enter number in base " + sourceBase + " to convert to base " +
                            targetBase + " (To go back type /back)");
                    String num1 = scanner.nextLine();
                    if (!num1.contains(".")) {
                        if (num1.matches("/back")) {
                            System.out.println();
                            break;
                        } else {
                            System.out.println("Conversion result: "
                                    + conversion(num1, sourceBase, targetBase) + "\n");
                        }
                    } else {

                        String[] separate = num1.split("\\.");
                        String fractional = separate[1];
                        String alph = "0123456789abcdefghijklmnopqrstuvwxyz";
                        // calculated integer part using below method.
                        String integerPart = conversion(separate[0], sourceBase, targetBase);

                        //To convert fractional part we have to first convert it to decimal and then to desired
                        //base
                        //https://www.youtube.com/watch?v=M6c6Xw5mt90
                        //https://www.youtube.com/watch?v=FvR7kxQ2spY
                        //These two videos are useful

                        //Converting to decimal
                        BigDecimal sum = BigDecimal.ZERO;
                        List<BigDecimal> inDeci = new ArrayList<>();
                        for (int i = 0; i < fractional.length(); i++) {
                            inDeci.add(BigDecimal.valueOf(alph.indexOf(fractional.charAt(i))));
                        }

                        for (int i = 0; i < inDeci.size(); i++) {
                            BigDecimal bd1 = sourceBase.pow(i + 1);
                            BigDecimal bd = inDeci.get(i).divide(bd1, 5, RoundingMode.CEILING);
                            sum = sum.add(bd);
                        }

                        //Converting to desired base.
                        int count = 0;
                        BigDecimal bigDecimal = sum;
                        List<Integer> integerList = new ArrayList<>();
                        do {
                            bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(targetBase));
                            String[] strings1 = bigDecimal.toPlainString().split("\\.");
                            integerList.add(Integer.valueOf(strings1[0]));
                            bigDecimal = bigDecimal.subtract(BigDecimal.valueOf(Long.parseLong(strings1[0])));
                            count++;
                        } while (integerList.size() < 5 || bigDecimal.equals(BigDecimal.ZERO));

                        StringBuilder finalFraction = new StringBuilder();
                        for (Integer i : integerList) {
                            finalFraction.append(alph.charAt(i));
                        }

                        System.out.println("Conversion result: " +integerPart + "." + finalFraction + "\n");
                    }
                } while (true);
            }
        } while (true);
    }

    public static String conversion(String num1, BigDecimal sourceBase, int targetBase) {
        int source = Integer.parseInt(sourceBase.toString());
        BigInteger number = new BigInteger(num1, source);
        BigInteger numInDecimal = new BigInteger(number.toString(10));
        return numInDecimal.toString(targetBase);
    }
}
