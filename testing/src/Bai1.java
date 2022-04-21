import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bai1 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println(isHappyNumber(n));
    }

    public static boolean isHappyNumber(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            n = sumSquareDigit(n);
            if (n == 1)
                return true;
            if (set.contains(n))
                return false;
            set.add(n);
        }
    }

    public static int sumSquareDigit(int n ) {
        int result = 0;
        while (n != 0) {
            result += (n%10) * (n%10);
            n /=10;
        }
        return result;
    }
}
