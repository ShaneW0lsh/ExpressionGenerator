import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Operator> operators = new ArrayList<Operator>();
        operators.add(new Sum());
        operators.add(new Substraction());
        operators.add(new Product());
        operators.add(new Division());

        for (int i = 0; i < 10; ++i) { 
            Expression e = new Expression(4, 1000, operators);
            System.out.println(String.format("%s = %d", e.toString(), e.evaluate()));
        }
    }
}
