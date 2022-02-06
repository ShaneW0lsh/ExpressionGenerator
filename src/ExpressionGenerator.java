import java.util.Random;
import java.util.Scanner;

// TODO: 
// 2. Answers are too big 


class ExpressionGenerator { 
    private static Random rand = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write in the depth and the number of expressions generated");

        int depth = sc.nextInt();
        int n = sc.nextInt();
        int border = 100;

        for (int i = 0; i < n; ++i) { 
            Expression expr = new Expression(depth, border);
            System.out.println(String.format("%s = %d", expr.toString(), expr.evaluate()));
        }
    }
}
