import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

/**
* This package of classes implements this grammar:
*         E => I
*         E => E + E
*         E => E - E
*         E => M * M
*         M => I
*         M => (E + E)
*         M => (E - E)
*         M => M * M
*
*           M stands for "multiplicant" and "multiplier"
**/

public class Expression {

    protected int mValue;
    protected String mStr;
    protected static Operators[] sOperators;
    protected static int[] sBase = {2, 3, 5};
    protected static HashMap<Integer, int[]> sBaseExponent;

    public Expression(int depth, int constraint, Operators[] operators) {
        sOperators = operators;
        initArray();
        create(depth, constraint);
    }

    public Expression(int depth, int constraint) {
        create(depth, constraint);
    }

    protected void create(int depth, int constraint) {
        final Expression out;

        if (depth <= 0)
            out = new IntExpression(constraint);
        else {
            Random rand = new Random();
            int ri = rand.nextInt(sOperators.length);
            switch(sOperators[ri]) { 
                case ADDITION:
                    out = new AdditionExpression(depth-(rand.nextInt(2)+1), constraint);
                    break;
                case SUBSTRACTION:
                    out = new SubstractionExpression(depth-(rand.nextInt(2)+1), constraint);
                    break;
                case MULTIPLICATION:
                    out = new MultiplicationExpression(depth-(rand.nextInt(2)+1), constraint);
                    break;
                case DIVISION:
                    out = new DivisionExpression(constraint);
                    break;
                case EXPONENTATION:
                    out = new ExponentationExpression();
                    break;
                default:
                    out = new Expression();
            }
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

    private void initArray() { 
        sBaseExponent = new HashMap<Integer, int[]>();
        int[] expTwo = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 16};
        int[] expThree = {2, 3, 4, 5};
        int[] expFive = {2, 3, 4, 5};
        sBaseExponent.put(new Integer(2), expTwo);
        sBaseExponent.put(new Integer(3), expThree);
        sBaseExponent.put(new Integer(5), expFive);
    }

}

class MExpression extends Expression {

    public MExpression(int depth, int constraint) {
        create(depth, constraint);
    }

    @Override
    protected void create(int depth, int constraint) {
        final Expression out;
        if (depth <= 0)
            out = new IntExpression(constraint);
        else {
            Random rand = new Random();
            int ri = rand.nextInt(sOperators.length);
            switch(sOperators[ri]) { 
                case ADDITION:
                    out = new AdditionMExpression(depth-(rand.nextInt(2)+1), constraint);
                    break;
                case SUBSTRACTION:
                    out = new SubstractionMExpression(depth-(rand.nextInt(2)+1), constraint);
                    break;
                case MULTIPLICATION:
                    out = new MultiplicationExpression(depth-(rand.nextInt(2)+1), constraint);
                    break;
                case DIVISION:
                    out = new DivisionExpression(constraint);
                    break;
                case EXPONENTATION:
                    out = new ExponentationExpression();
                    break;
                default:
                    out = new Expression();
            }
        }
        mValue = out.evaluate();
        mStr = out.toString();
    }
}

class AdditionExpression extends Expression {

    public AdditionExpression(int depth, int constraint) {
        Random rand = new Random();
        Expression left = new Expression(depth-(rand.nextInt(2)+1), constraint/2), 
                   right = new Expression(depth-(rand.nextInt(2)+1), constraint/2);

        mValue = left.evaluate() + right.evaluate();
        mStr = String.format("%s+%s", left.toString(), right.toString());
    }
}

class AdditionMExpression extends Expression {

    public AdditionMExpression(int depth, int constraint) {
        Random rand = new Random();
        Expression left = new Expression(depth-(rand.nextInt(2)+1), constraint/2),
                   right = new Expression(depth-(rand.nextInt(2)+1), constraint/2);

        mValue = left.evaluate() + right.evaluate();
        mStr = String.format("(%s+%s)", left.toString(), right.toString());
    }
}

class SubstractionExpression extends Expression {

    public SubstractionExpression(int depth, int constraint) {
        Random rand = new Random();
        Expression left = new Expression(depth-(rand.nextInt(2)+1), constraint),
                   right = new Expression(depth-(rand.nextInt(2)+1), constraint);

        mValue = left.evaluate() - right.evaluate();
        mStr = String.format("%s-%s", left.toString(), right.toString());
    }
}

class SubstractionMExpression extends Expression {

    public SubstractionMExpression(int depth, int constraint) {
        Random rand = new Random();
        Expression left = new Expression(depth-(rand.nextInt(2)+1), constraint),
                   right = new Expression(depth-(rand.nextInt(2)+1), constraint);

        mValue = left.evaluate() - right.evaluate();
        mStr = String.format("(%s-%s)", left.toString(), right.toString());
    }
}


class MultiplicationExpression extends Expression {

    public MultiplicationExpression(int depth, int constraint) {
        Random rand = new Random();
        Expression left = new MExpression(depth-(rand.nextInt(2)+1), 
                        (int)Math.ceil(Math.sqrt(constraint))),
                   right = new MExpression(depth-(rand.nextInt(2)+1), 
                        (int)Math.ceil(Math.sqrt(constraint)));

        mValue = left.evaluate() * right.evaluate();
        mStr = String.format("%s*%s", left.toString(), right.toString());
    }
}

class DivisionExpression extends Expression {

    public DivisionExpression(int constraint) {
        int divident = new IntExpression(constraint).evaluate();
        ArrayList<Integer> divisors = getDivisors(divident);
        int divisor = new IntExpression(divisors).evaluate();
        mValue = divident / divisor;
        mStr = String.format("%s/%s", Integer.toString(divident), Integer.toString(divisor));
    }

    private ArrayList<Integer> getDivisors(int divident) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 2; i * i < divident; ++i) {
            if (divident % i == 0) {
                divisors.add(i);
                divisors.add(divident / i);
            }
        }
        return divisors;
    }
}

class ExponentationExpression extends Expression { 

    public ExponentationExpression() { 
        Random rand = new Random();
        int rBase = sBase[rand.nextInt(sBase.length)];
        int[] exponents = sBaseExponent.get(rBase);
        int rExp = exponents[rand.nextInt(exponents.length)];
        
        mValue = (int)Math.pow(rBase, rExp);
        mStr = String.format("%d^%d", rBase, rExp);
    }
}

class IntExpression extends Expression {

    public IntExpression(int constraint) {
        constraint = (constraint < 1) ? 1 : constraint;
        Random rand = new Random();
        mValue = rand.nextInt(constraint) + 1;
        mStr = Integer.toString(mValue);
    }

    public IntExpression(ArrayList<Integer> divisors) {
        Random rand = new Random();
        if (divisors.size() == 0) { 
            mValue = rand.nextInt(10) + 1;
            mStr = Integer.toString(mValue);
        } else {
            int ri = rand.nextInt(divisors.size());
            mValue = divisors.get(ri);
            mStr = Integer.toString(mValue);
        }
    }
}
