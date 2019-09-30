
/*
 * Author: Silvestri
 *
 * A Library of My Favorite Methods
*/
 
package Chapter6;
 
public class Library {
    public static String version = "1.1";
   
    public static String repeatString(String str, int count) {
        String specFmt = String.format("%%%ds", count);
        String countSpaces = String.format(specFmt, " ");
        return countSpaces.replace(" ", str);
    }
   
    public static boolean isPrime(int number) {
        int upperFactorLimit = (int)Math.sqrt(number);
        for (int divisor = 2; divisor <= upperFactorLimit; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
   
    public static int gcd(int n1, int n2) {
        int rem;
        while ((rem = n1 % n2) != 0) {
            n1 = n2;
            n2 = rem;
        }
        return n2;
    }
   
    public static int max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }
   
    public static int max(int num1, int num2, int num3) {
        return max(max(num1, num2), num3);
    }
   
}
