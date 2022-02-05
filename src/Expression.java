import java.util.Random;

interface Expression {
    public String toString();
    public int evaluate();
}

class AddExpression implements Expression {
    private LeftExpression lExpr;
    private RightExpression rExpr;

    private int value;
    private String inString;

    public AddExpression(int depth) { 
        this.lExpr = new LeftExpression(depth-1);
        this.rExpr = new RightExpression(depth-1);

        this.value = lExpr.evaluate() + rExpr.evaluate();
        this.inString = String.format("(%s + %s)", lExpr.toString(), rExpr.toString());    
    }

    public String toString() {
        return this.inString;
    }

    public int evaluate() {
        return this.value;
    }
}

class MultiplyExpression implements Expression {
    private LeftExpression lExpr;
    private RightExpression rExpr;

    private int value;
    private String inString;

    public MultiplyExpression(int depth) { 
        this.lExpr = new LeftExpression(depth-1);
        this.rExpr = new RightExpression(depth-1);

        this.value = lExpr.evaluate() * rExpr.evaluate();
        this.inString = String.format("%s * %s", lExpr.toString(), rExpr.toString());    
    }

    public String toString() {
        return this.inString;
    }

    public int evaluate() {
        return this.value;
    }
}

class LeftExpression implements Expression {
    private Expression outExpr;

    private int value;
    private String inString;

    public LeftExpression(int depth) {
        if (depth <= 0) {
            this.outExpr = new IntExpression(depth-1);
        } else {
            Random rand = new Random();
            int p = rand.nextInt(2);
            if (p == 1) {
                this.outExpr = new AddExpression(depth-1);
            } else { 
                this.outExpr = new MultiplyExpression(depth-1);
            }
        }
        this.value = outExpr.evaluate();
        this.inString = outExpr.toString();
    }

    public String toString() {
        return this.inString;
    }

    public int evaluate() {
        return this.value;
    }
}

class RightExpression implements Expression { 
    private Expression outExpr;

    private int value;
    private String inString;

    public RightExpression(int depth) {
        if (depth <= 0) {
            this.outExpr = new IntExpression(depth-1);
        } else {
            Random rand = new Random();
            int p = rand.nextInt(2);
            if (p == 1) {
                this.outExpr = new AddExpression(depth-1);
            } else { 
                this.outExpr = new MultiplyExpression(depth-1);
            }
        }
        this.value = outExpr.evaluate();
        this.inString = outExpr.toString();
    }

    public String toString() {
        return this.inString;
    }

    public int evaluate() {
        return this.value;
    }
}

class IntExpression implements Expression {
    private int value;
    private String inString;

    public IntExpression(int depth) {
        Random rand = new Random();
        this.value = rand.nextInt(101);
        // System.out.println("A value was successfully generated: " + this.value);
        this.inString = Integer.toString(this.value);
    }

    public String toString() { 
        return this.inString;
    }

    public int evaluate() {
        return this.value;
    }
}
