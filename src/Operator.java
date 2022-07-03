import java.util.ArrayList;

public interface Operator { 
    Expression generate(int depth, int constraint, boolean braces);
}

class Sum implements Operator { 

    public Sum() {}

    public Expression generate(int depth, int constraint, boolean braces) {
        return (braces ? new AddMExpression(depth, constraint) 
                       : new AddExpression(depth, constraint));
        /*
        if (braces)
            return new AddMExpression();
        return new AddExpression();
        */
    }
}

class Product implements Operator { 

    public Product() {}

    public Expression generate(int depth, int constraint, boolean braces) { 
        return new MultiplyExpression(depth, constraint);
    }
}
