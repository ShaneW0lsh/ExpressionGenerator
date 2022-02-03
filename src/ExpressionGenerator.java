import java.util.Random;
import java.util.Scanner;

class ExpressionGenerator { 
    private static Random rand = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("write in the depth and the number of expressions generated");

        int depth = sc.nextInt();
        int n = sc.nextInt();

        Expression expr = generate(depth);
        for (int i = 0; i < n; ++i) { 
            expr = generate(depth);
            System.out.println(String.format("%s = %d", expr.toString(), expr.evaluate()));
        }
    }

    public static Expression generate(int depth) {
        Expression expr;

        int p = rand.nextInt(2);
        if (p == 0) {
            expr = new MultiplyExpression(depth);
        } else {
            expr = new AddExpression(depth);
        }

        return expr;
    }
}
