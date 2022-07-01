package operator;

import expression;

class Sum implements Operator { 

    public Expression generate(int depth, int constraint,
                                    boolean braces) { 
        return braces ? AddMExpression(depth, constraint) 
                      : AddExpression(depth, constraint);
    }
}
