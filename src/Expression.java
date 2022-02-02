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

    public String evaluate() { 
        lExpr = new LeftExpression();
        rExpr = new RightExpression();

        String ret = lExpr.evaluate() + "+" + rExpr.evaluate();

        return ret;
    }
}

class LeftExpression {

    public String evaluate() {
        IntExpression iExpr = new IntExpression();
        return iExpr.evaluate();
    }
}

class RightExpression {

    public String evaluate() { 
        IntExpression iExpr = new IntExpression();
        return iExpr.evaluate();
    }
}

class IntExpression {

    public String evaluate() {
        Random rand = new Random();
        int ret = rand.nextInt(100);

        return Integer.toString(ret);
    }
}
