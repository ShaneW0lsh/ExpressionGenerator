import java.util.Random;
import java.util.Scanner;

// TODO: 
// 3. Integrate this into the main project 
// 4. Organize packages in the main project, call this one Expression, and the main one


class ExpressionGenerator { 
    private static Random rand = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write in the depth and the number of expressions generated");

        int depth = sc.nextInt();
        int n = sc.nextInt();
        int border = 5000;
        
        int biggest = 0;
        for (int i = 0; i < n; ++i) { 
            Expression expr = new Expression(depth, border);
            biggest = Math.max(biggest, expr.evaluate());
            System.out.println(String.format("%s = %d", expr.toString(), expr.evaluate()));
        }

        System.out.println(biggest);
    }
}
