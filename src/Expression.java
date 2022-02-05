import java.util.Random;

// E 
class Expression {
    private Expression out;

    private int value;
    private String inString;

    public Expression() {

    }

    public Expression(int depth) {
        if (depth <= 0) {
            this.out = new IntExpression(depth-1);
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
    private Expression out;

    private int value;
    private String inString;

    public mExpression(int depth) {
        if (depth <= 0) {
            this.out = new IntExpression(depth-1);
        } else {
            Random rand = new Random();
            int p = rand.nextInt(2);
            if (p == 1) {
                this.out = new MultiplyExpression(depth-1);
            } else { 
  found: no argument
                this.out = new AddMExpression(depth-1);
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

class AddExpression extends Expression {
    private Expression left, right;

    private int value;
    private String inString;

    public AddExpression(int depth) { 
        this.left = new Expression(depth-1);
        this.right = new Expression(depth-1);

        this.value = left.evaluate() + right.evaluate();
        this.inString = String.format("%s + %s", left.toString(), right.toString());    
    }

    public String toString() {
        return this.inString;
    }

    public int evaluate() {
        return this.value;
    }
}

class AddMExpression extends Expression {
    private Expression left, right;

    private int value;
    private String inString;

    public AddMExpression(int depth) { 
        this.left = new Expression(depth-1);
        this.right = new Expression(depth-1);

        this.value = left.evaluate() + right.evaluate();
        this.inString = String.format("(%s + %s)", left.toString(), right.toString());    
    }

    public String toString() {
        return this.inString;
    }

    public int evaluate() {
        return this.value;
    }
}

//TODO: rewrite this in a more OOP way; remove all those value, inString, because it's extending 
class MultiplyExpression extends Expression {
    private Expression left, right;

    private int value;
    private String inString;

    public MultiplyExpression(int depth) { 
        this.left = new mExpression(depth-1);
        this.right = new mExpression(depth-1);

        this.value = left.evaluate() * right.evaluate();
        this.inString = String.format("%s * %s", left.toString(), right.toString());    
    }

    public String toString() {
        return this.inString;
    }

    public int evaluate() {
        return this.value;
    }
}


class IntExpression extends Expression {
    private int value;
    private String inString;


    public IntExpression(int depth) {
        Random rand = new Random();
        this.value = rand.nextInt(101);
        this.inString = Integer.toString(this.value);
    }

    public String toString() { 
        return this.inString;
    }

    public int evaluate() {
        return this.value;
    }
}
