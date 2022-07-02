import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Operator> oper = new ArrayList<Operator>();
        oper.add(new Sum())
        oper.add(new Product());

        Expression e = new Expression(2, 1000, oper);
        String estr = e.toString();
        System.out.println(estr);
    }
}
