package com.shane.mathack.util.expression;

import java.util.Random;

class IntExpression extends Expression {

    public IntExpression(int constraint) {
        Random rand = new Random();
        mValue = rand.nextInt(constraint) + 1;
        mStr = Integer.toString(mValue);
    }
}