import java.util.Random;

interface Expression {

    public String buildWord(int depth);
}

class AddExpression implements Expression{
    private LeftExpression lExpr;
    private RightExpression rExpr;

    public AddExpression() { 

    }
    
    public String buildWord(int depth) {
        this.lExpr = new LeftExpression();
        this.rExpr = new RightExpression();
        return String.format("(%s + %s)", lExpr.buildWord(depth-1), rExpr.buildWord(depth-1));
    }
}

class MultiplyExpression implements Expression{
    private LeftExpression lExpr;
    private RightExpression rExpr;

    public MultiplyExpression() { 

    }
    
    public String buildWord(int depth) {
        this.lExpr = new LeftExpression();
        this.rExpr = new RightExpression();
        return String.format("%s * %s", lExpr.buildWord(depth-1), rExpr.buildWord(depth-1));   
    }
}

class LeftExpression implements Expression {
    private IntExpression intExpr;
    private MultiplyExpression mulExpr;
    private AddExpression addExpr;

    // is created recursively
    public LeftExpression() {

    }

    public String buildWord(int depth) {
        if (depth <= 0) {
            this.intExpr = new IntExpression();
            return intExpr.buildWord(depth-1);
        } else {
            Random rand = new Random();
            int p = rand.nextInt(2);

            if (p == 1) {
                this.addExpr = new AddExpression();
                return addExpr.buildWord(depth-1);
            } else { 
                this.mulExpr = new MultiplyExpression();
                return mulExpr.buildWord(depth-1);
            }
        }
    }
}

class RightExpression implements Expression { 
    private IntExpression intExpr;
    private MultiplyExpression mulExpr;
    private AddExpression addExpr;

    public RightExpression() {

    }

    public String buildWord(int depth) {
        if (depth <= 0) {
            this.intExpr = new IntExpression();
            return intExpr.buildWord(depth-1);
        } else {
            Random rand = new Random();
            int p = rand.nextInt(2);

            if (p == 1) {
                this.addExpr = new AddExpression();
                return addExpr.buildWord(depth-1);

            } else { 
                this.mulExpr = new MultiplyExpression();
                return mulExpr.buildWord(depth-1);
            }
        }
    }
}

class IntExpression implements Expression {
    private int value;
    private Random rand;

    public IntExpression() {
        this.rand = new Random();
    }

    public String buildWord(int depth) {
        int value = rand.nextInt(101);
        this.value = value;

        return Integer.toString(value);
    }

    public int getValue() {
        return this.value;
    }
}
