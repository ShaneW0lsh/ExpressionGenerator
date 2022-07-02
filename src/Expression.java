import java.util.Random;
import java.util.ArrayList;

// This package of classes implements this grammar:
//
// E -> I
// E -> E + E
// E -> M * M
// M -> I
// M -> (E + E)
// M -> M * M

public class Expression {

    public Expression(int depth, int constraint,
                    ArrayList<Operator> operators) {
        final Expression out;
        if (depth <= 0)
            out = new IntExpression(constraint);
        else {
            Random rand = new Random();
            int ri = rand.nextInt(operators.size());
            out = operators.get(ri).generate(depth, constraint, operators, false); // try adding -1
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

    protected int mValue;
    protected String mStr;
}

class MExpression extends Expression {

    public MExpression(int depth, int constraint,
            ArrayList<Operator> operators) {
        final Expression out;
        if (depth <= 0)
            out = new IntExpression(constraint);
        else {
            Random rand = new Random();
            int ri = rand.nextInt(operators.size());
            out = operators.get(ri).generate(depth, constraint, operators, true);
        }
        mValue = out.evaluate();
        mStr = out.toString();
    }
}

class AddExpression extends Expression {

    public AddExpression(int depth, int constraint,
            ArrayList<Operator> operators) {
        final Expression left, right;
        left = new Expression(depth-1, constraint/2, operators);
        right = new Expression(depth-1, constraint/2, operators);

        mValue = left.evaluate() + right.evaluate();
        mStr = String.format("%s+%s", left.toString(), right.toString());
    }
}

class AddMExpression extends Expression {

    public AddMExpression(int depth, int constraint,
            ArrayList<Operator> operators) {
        final Expression left, right;
        left = new Expression(depth-1, constraint/2, operators);
        right = new Expression(depth-1, constraint/2, operators);

        mValue = left.evaluate() + right.evaluate();
        mStr = String.format("(%s+%s)", left.toString(), right.toString());
    }
}

class MultiplyExpression extends Expression {

    public MultiplyExpression(int depth, int constraint,
            ArrayList<Operator> operators) {
        final Expression left, right;
        left = new MExpression(depth-1, (int)Math.ceil(Math.sqrt(constraint)), operators);
        right = new MExpression(depth-1, (int)Math.ceil(Math.sqrt(constraint)), operators);

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








            /*
            if (0 == r.nextInt(2))
                out = new AddExpression(depth - 1, constraint);
            else
                out = new MultiplyExpression(depth - 1, constraint);
                */
