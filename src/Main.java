import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Operators[] op = { Operators.EXPONENTATION };

        for (int i = 0; i < 10; ++i) { 
            Expression e = new Expression(3, 1000, op);
            System.out.println(String.format("%s = %d", e.toString(), e.evaluate()));
        }
    }
}
