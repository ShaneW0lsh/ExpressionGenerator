package expression;

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
            int ri = r.nextInt(operators.size());
            operators[ri].generate(depth, constraint);


            /*
            if (0 == r.nextInt(2))
                out = new AddExpression(depth - 1, constraint);
            else
                out = new MultiplyExpression(depth - 1, constraint);
                */
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
