import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Operator> oper = new ArrayList<Operator>();
        oper.add(new Sum());
        oper.add(new Product());

        for (int i = 0; i < 10; ++i) { 
            Expression e = new Expression(2, 5000, oper);
            System.out.println(String.format("%s = %d", e.toString(), e.evaluate()));
        }
    }
}
