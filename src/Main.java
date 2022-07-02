package main;

import expression.Expression;

public class Main { 

    public static void main(String[] args) { 
        ArrayList<Operator> oper = new ArrayList();
        oper.add(new Sum());

        String e = Expression(3, 1000, oper);
        System.out.println(e);
    }
}
