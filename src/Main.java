import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Operator> operators = new ArrayList<Operator>();
        operators.add(new Sum());
        operators.add(new Product());

        for (int i = 0; i < 10; ++i) { 
            Expression e = new Expression(3, 500, operators);
            System.out.println(String.format("%s = %d", e.toString(), e.evaluate()));
        }
    }
}
