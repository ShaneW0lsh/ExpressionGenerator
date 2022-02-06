import java.util.Random;

// E 
class Expression {
    protected Expression out;

    protected int value;
    protected String inString;

    public Expression() {

    }

    public Expression(int depth) {
        if (depth <= 0) {
            this.out = new IntExpression();
        } else {
            Random rand = new Random();
            int p = rand.nextInt(2);
            if (p == 1) {
                this.out = new AddExpression(depth-1);
            } else { 
                this.out = new MultiplyExpression(depth-1);
            }
        }
        this.value = out.evaluate();
        this.inString = out.toString();
    }

    public String toString() {
        return this.inString;
    }

    public int evaluate() { 
        return this.value;
    }
}

// M
class mExpression extends Expression{ 

    public mExpression(int depth) {
        if (depth <= 0) {
            this.out = new IntExpression();
        } else {
            Random rand = new Random();
            int p = rand.nextInt(2);
            if (p == 1) {
                this.out = new MultiplyExpression(depth-1);
            } else { 
                this.out = new AddMExpression(depth-1);
            }
        }
        this.value = out.evaluate();
        this.inString = out.toString();
    }
}

class AddExpression extends Expression {
    private Expression left, right;

    public AddExpression(int depth) { 
        this.left = new Expression(depth-1);
        this.right = new Expression(depth-1);

        this.value = left.evaluate() + right.evaluate();
        this.inString = String.format("%s + %s", left.toString(), right.toString());    
    }
}

class AddMExpression extends Expression {
    private Expression left, right;

    public AddMExpression(int depth) { 
        this.left = new Expression(depth-1);
        this.right = new Expression(depth-1);

        this.value = left.evaluate() + right.evaluate();
        this.inString = String.format("(%s + %s)", left.toString(), right.toString());    
    }
}

class MultiplyExpression extends Expression {
    private Expression left, right;

    public MultiplyExpression(int depth) { 
        this.left = new mExpression(depth-1);
        this.right = new mExpression(depth-1);

        this.value = left.evaluate() * right.evaluate();
        this.inString = String.format("%s * %s", left.toString(), right.toString());    
    }
}


class IntExpression extends Expression {

    public IntExpression() {
        Random rand = new Random();
        this.value = rand.nextInt(101);
        this.inString = Integer.toString(this.value);
    }
}
