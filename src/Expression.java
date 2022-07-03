import java.util.Random;
import java.util.ArrayList;

/**
* This package of classes implements this grammar:
*         E => I
*         E => E + E
*         E => M * M
*         M => I
*         M => (E + E)
*         M => M * M
*
*           M stands for "multiplicant" and "multiplier"
**/

public class Expression {

    protected int mValue;
    protected String mStr;
    protected static ArrayList<Operator> sOperators;

    public Expression(int depth, int constraint,
                      ArrayList<Operator> operators) {
        sOperators = operators;
        create(depth, constraint);
    }

    public Expression(int depth, int constraint) {
        create(depth, constraint);
    }

    private void create(int depth, int constraint) {
        final Expression out;
        if (depth <= 0)
            out = new IntExpression(constraint);
        else {
            Random rand = new Random();
            int ri = rand.nextInt(sOperators.size());
            out = sOperators.get(ri).generate(depth-1, constraint, false); // try adding -1
        }

        mValue = out.evaluate();
        mStr = out.toString();
    }

    public Expression() {}

    public String toString() {
        return mStr;
    }

    public int evaluate() {
        return mValue;
    }
}

class AddExpression extends Expression {

    public AddExpression(int depth, int constraint) {
        final Expression left, right;
        left = new Expression(depth-1, constraint/2);
        right = new Expression(depth-1, constraint/2);

        mValue = left.evaluate() + right.evaluate();
        mStr = String.format("%s+%s", left.toString(), right.toString());
    }
}

class AddMExpression extends Expression {

    public AddMExpression(int depth, int constraint) {
        final Expression left, right;
        left = new Expression(depth-1, constraint/2, sOperators);
        right = new Expression(depth-1, constraint/2, sOperators);

        mValue = left.evaluate() + right.evaluate();
        mStr = String.format("(%s+%s)", left.toString(), right.toString());
    }
}

class MExpression extends Expression {

    public MExpression(int depth, int constraint) {
        create(depth, constraint);
    }

    private void create(int depth, int constraint) {
        final Expression out;
        if (depth <= 0)
            out = new IntExpression(constraint);
        else {
            Random rand = new Random();
            int ri = rand.nextInt(sOperators.size());
            out = sOperators.get(ri).generate(depth-1, constraint, true); // try adding -1
        }

        mValue = out.evaluate();
        mStr = out.toString();
    }
}

class MultiplyExpression extends Expression {

    public MultiplyExpression(int depth, int constraint) {
        final Expression left, right;
        left = new MExpression(depth-1, (int)Math.ceil(Math.sqrt(constraint)));
        right = new MExpression(depth-1, (int)Math.ceil(Math.sqrt(constraint)));

        mValue = left.evaluate() * right.evaluate();
        mStr = String.format("%s*%s", left.toString(), right.toString());
    }
}

class IntExpression extends Expression {

    public IntExpression(int constraint) {
        constraint = (constraint < 1) ? 1 : constraint;
        Random rand = new Random();
        mValue = rand.nextInt(constraint) + 1;
        mStr = Integer.toString(mValue);
    }
}
