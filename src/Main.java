import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main {

    //TODO: create param class with needed properties
    public static void main(String[] args) {
        Parameters param = new Parameters();

        Operators[] op = { Operators.EXPONENTATION, Operators.ADDITION,
                           Operators.SUBSTRACTION, Operators.MULTIPLICATION,
                           Operators.DIVISION };
        param.setOperators(op);
        
        param.setDepth(5);
        param.setConstraint(1000);

        HashMap<Integer, int[]> be = new HashMap<Integer, int[]>();
        int[] expTwo = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 16};
        int[] expThree = {2, 3, 4, 5};
        int[] expFive = {2, 3, 4, 5};
        be.put(new Integer(3), expThree);
        be.put(new Integer(2), expTwo);
        be.put(new Integer(5), expFive);
        param.setBaseExponent(be);

        for (int i = 0; i < 20; ++i) { 
            Expression e = new Expression(param);
            System.out.println(String.format("%s = %d", e.toString(), e.evaluate()));
        }
    }
}
