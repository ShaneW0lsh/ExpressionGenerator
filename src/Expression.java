import java.util.Random;

class Expression {
    public String evaluate() { 
        AddExpression aExpr = new AddExpression();

        return aExpr.evaluate();
    }
}


class AddExpression {
    LeftExpression lExpr;
    RightExpression rExpr;

    // public AddExpression() { 
    //     evaluate();
    // }
    public String evaluate() { 
        lExpr = new LeftExpression();
        rExpr = new RightExpression();

        String ret = lExpr.evaluate() + "+" + rExpr.evaluate();

        return ret;
    }

}

class LeftExpression {

    public int evaluate() {
        return IntExpression.evaluate();   
    }
}

class RightExpression {

    public int evaluate() { 
        return IntExpression.evaluate();   
    }
}

class IntExpression {

    public static int evaluate() {
        Random rand = new Random();
        int ret = rand.nextInt(100);
        return ret;
    }
}
