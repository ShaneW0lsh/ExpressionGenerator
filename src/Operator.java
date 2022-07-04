import java.util.ArrayList;

public interface Operator { 
    Expression generate(int depth, int constraint, boolean braces);
}

class Sum implements Operator { 

    public Sum() {}

    public Expression generate(int depth, int constraint, boolean braces) {
        return (braces ? new AdditionMExpression(depth, constraint) 
                       : new AdditionExpression(depth, constraint));
        /*
        if (braces)
            return new AdditionMExpression();
        return new AdditionExpression();
        */
    }
}

class Substraction implements Operator { 
    
    public Substraction() {}

    public Expression generate(int depth, int constraint, boolean braces) {
        if (braces)
            return new SubstractionMExpression(depth, constraint);
        return new SubstractionExpression(depth, constraint);
    }
}

class Product implements Operator { 

    public Product() {}

    public Expression generate(int depth, int constraint, boolean braces) { 
        return new MultiplicationExpression(depth, constraint);
    }
}

class Division implements Operator { 

    public Division() {}

    public Expression generate(int depth, int constraint, boolean braces) { 
        return new DivisionExpression(constraint);
    }
}
