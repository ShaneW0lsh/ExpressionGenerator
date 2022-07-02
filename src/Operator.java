import java.util.ArrayList;

public interface Operator { 
    Expression generate(int depth, int constraint,
            ArrayList<Operator> operators, boolean braces);
}

class Sum implements Operator { 

    public Sum() {}

    public Expression generate(int depth, int constraint,
            ArrayList<Operator> operators, boolean braces) {
        if (braces) {
            return new AddMExpression(depth, constraint, operators);
        }
        return new AddExpression(depth, constraint, operators);
    }
}

class Product implements Operator { 

    public Product() {}

    public Expression generate(int depth, int constraint,
            ArrayList<Operator> operators, boolean braces) { 
        return new MultiplyExpression(depth, constraint, operators);
    }
}
