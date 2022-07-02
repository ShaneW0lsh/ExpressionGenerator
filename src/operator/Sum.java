package operator;

import expression;

class Sum implements Operator { 

    public Sum() {}

    public Expression generate(int depth, int constraint) {
        return AddExpression(depth, constraint);
    }
}
