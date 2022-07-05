import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    ///TODO: create param class with needed properties
    public static void main(String[] args) {
        ExprParameters param = new ExprParameters();

        Operators[] op = { Operators.EXPONENTATION };
        param.setOperators(op);
        
        param.setMaxDepth(3);
        param.setMaxAnswer(1000);

        HashMap<Integer, int[]> be;
        int[] expTwo = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 16};
        int[] expThree = {2, 3, 4, 5};
        int[] expFive = {2, 3, 4, 5};
        be.put(new Integer(2), expTwo);
        be.put(new Integer(3), expThree);
        be.put(new Integer(5), expFive);
        param.setBaseExponent(be);

        for (int i = 0; i < 10; ++i) { 
            Expression e = new Expression(3, 1000, op);
            System.out.println(String.format("%s = %d", e.toString(), e.evaluate()));
        }
    }
}
