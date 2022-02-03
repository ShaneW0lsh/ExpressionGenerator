import java.util.Random;

// create a tree structure 
class ExpressionGenerator { 

    public static void main(String[] args) {
        int depth = 4;
        Expression expr = new AddExpression();
        Expression expr2 = new AddExpression();

        String word = expr.buildWord();
        for (int i = 0; i < 10; ++i) { 
            word = expr.buildWord();
            System.out.println(String.format("%s", word));
        }
    }
}
