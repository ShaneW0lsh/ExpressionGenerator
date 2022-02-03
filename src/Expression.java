import java.util.Random;

interface Expression {

    public String buildWord();
}


class AddExpression implements Expression{
    private LeftExpression lExpr;
    private RightExpression rExpr;

    public AddExpression() { 
        this.lExpr = new LeftExpression();
        this.rExpr = new RightExpression();
    }
    
    public String buildWord() {
        return lExpr.buildWord() + " + " + rExpr.buildWord();
    }
}

class LeftExpression implements Expression {
    private IntExpression intExpr;

    public LeftExpression() {
        this.intExpr = new IntExpression();
    }

    public String buildWord() {
        return intExpr.buildWord();
    }
}

class RightExpression implements Expression { 
    private IntExpression intExpr;

    public RightExpression() {
        this.intExpr = new IntExpression();
    }

    public String buildWord() {
        return intExpr.buildWord();
    }
}

class IntExpression implements Expression {
    private int value;
    private Random rand;

    public IntExpression() {
        this.rand = new Random();
    }

    public String buildWord() {
        int value = rand.nextInt(101);
        this.value = value;

        return Integer.toString(value);
    }

    public int getValue() {
        return this.value;
    }
}
