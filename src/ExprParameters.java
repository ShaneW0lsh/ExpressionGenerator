import java.util.HashMap;

public class ExprParameters { 

    private Operators[] mOperators;
    private HashMap<Integer, int[]> mBaseExponent;

    ExprParameters() {}

    public void setOperators(Operators[] op) {
        mOperators = op;
    }

    public Operators[] getOperators() {
        return mOperators;
    }

    public void setMaxDepth(int d) {
        mDepth = d; 
    }

    public int getMaxDepth() { 
        return mDepth;
    }

    public void setMaxAnswer(int a) { 
        mAnswer = a;
    }

    public int getMaxAnswer() { 
        return mAnswer;
    }

    public void setBaseExponent(HashMap<Integer, int[]> be) { 
        mBaseExponent = new HashMap<Integer, int[]>(be);
    }

    public HashMap<Integer, int[]> setBaseExponent() { 
        return mBaseExponent;
    }
}
