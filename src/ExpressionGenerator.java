import java.util.Random;

// create a tree structure 
class ExpressionGenerator { 
    private static Random rand = new Random();

    public static void main(String[] args) {
        Expression expr = new MultiplyExpression();

        String word = generate();
        for (int i = 0; i < 10; ++i) { 
            word = generate();
            System.out.println(String.format("%s", word));
        }
    }

    public static String generate() {
        Expression expr;
        int p = rand.nextInt(2);
        if (p == 0) {
            expr = new MultiplyExpression();
        } else {
            expr = new AddExpression();
        }

        return expr.buildWord();
    }
}
