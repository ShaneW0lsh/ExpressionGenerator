import java.util.ArrayList;

public interface Operator { 
    Expression generate(int depth, int constraint, ArrayList<Operator> operators);
}

class Sum implements Operator { 

    public Sum() {}

    public Expression generate(int depth, int constraint,
            ArrayList<Operator> operators) {
        return new AddExpression(depth, constraint, operators);
    }
}

