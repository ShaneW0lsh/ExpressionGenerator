import java.util.Random;
import java.util.Scanner;

// create a tree structure 
class ExpressionGenerator { 
    private static Random rand = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Expression expr = new MultiplyExpression();

        System.out.println("write in the depth and the number of expressions generated");
        int depth = sc.nextInt();
        int n = sc.nextInt();

        String word = generate(depth);
        for (int i = 0; i < n; ++i) { 
            word = generate(depth);
            System.out.println(String.format("%s", word));
        }
    }

    public static String generate(int depth) {
        Expression expr;
        int p = rand.nextInt(2);
        if (p == 0) {
            expr = new MultiplyExpression();
        } else {
            expr = new AddExpression();
        }

        return expr.buildWord(depth);
    }
}
