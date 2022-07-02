package expression;

import java.util.Random;

public class MExpression extends Expression {

    public MExpression(int depth, int constraint) {
        final Expression out;
        if (depth <= 0)
            out = new IntExpression(constraint);
        else {
            Random rand = new Random();
            out = newAddMExpression(depth-1, constraint);
            /*
            if (0 == rand.nextInt(2))
                out = new MultiplyExpression(depth - 1, constraint);
            else
                out = new AddMExpression(depth - 1, constraint);
                */
        }
        mValue = out.evaluate();
        mStr = out.toString();
    }
}
