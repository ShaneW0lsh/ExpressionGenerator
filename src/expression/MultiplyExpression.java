package expression;

class MultiplyExpression extends Expression {

    public MultiplyExpression(int depth, int constraint) {
        final Expression left, right;
        left = new MExpression(depth-1, (int)Math.sqrt(constraint));
        right = new MExpression(depth-1, (int)Math.sqrt(constraint));

        mValue = left.evaluate() * right.evaluate();
        mStr = String.format("%s * %s", left.toString(), right.toString());
    }
}
