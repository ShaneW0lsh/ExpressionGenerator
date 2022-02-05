import java.util.Random;
import java.util.Scanner;

// TODO: 
//
// implement that "less clustered" grammar
// 1. rewrite expression into a class, and make everything be extendend from it, instead of them implementing 
// 2. create an expression which is an argument for a multiplication
// 3. implement all of it's qualities

// new one 
// E -> I
// E -> M '*' M
// E -> E '+' E
// M -> I
// M -> M '*' M
// M -> '(' E '+' E ')'

// old one
// E -> I
// E -> (E + E)
// E -> E * E

class ExpressionGenerator { 
    private static Random rand = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write in the depth and the number of expressions generated");

        int depth = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 0; i < n; ++i) { 
            Expression expr = new Expression(depth);
            System.out.println(String.format("%s = %d", expr.toString(), expr.evaluate()));
        }
    }
}
