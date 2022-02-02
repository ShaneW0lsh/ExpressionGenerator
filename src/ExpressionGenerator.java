import java.util.Random;

class ExpressionGenerator { 
    Random rand = new Random();

    public static void main(String[] args) {
        Expression expr = new Expression();

        for (int i = 0; i < 10; ++i) {
            System.out.println(expr.evaluate());
        }
    }
    
    // public Expression evaluate(Expression expr, int depth) { 
    //     if (depth <= 2) {
    //         return expr;
    //     }
    //     int p = rand.nextInt(3);
    //     if (p == 0) {
    //         return evaluate(new MultiplyExpression(), depth-1);
    //     } else if (p == 1) {
    //         return evaluate(new AddExpression(), depth-1);
    //     } else if (p == 2) {
    //         return evaluate(new IntExpression(), depth-1);
    //     }
    // }
}
