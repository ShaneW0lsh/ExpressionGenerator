import java.util.HashMap;

public class Parameters { 

    private Operators[] mOperators;
    private HashMap<Integer, int[]> mBaseExponent;
    private int mDepth = 3,
                mConstraint = 300;

    Parameters() {}

    public void setOperators(Operators[] op) {
        mOperators = op;
    }

    public Operators[] getOperators() {
        return mOperators;
    }

    public void setDepth(int d) {
        mDepth = d; 
    }

    public int getDepth() { 
        return mDepth;
    }

    public void setConstraint(int c) { 
        mConstraint = c;
    }

    public int getConstraint() { 
        return mConstraint;
    }

    public void setBaseExponent(HashMap<Integer, int[]> be) { 
        mBaseExponent = new HashMap<Integer, int[]>(be);
    }

    public HashMap<Integer, int[]> getBaseExponent() { 
        return mBaseExponent;
    }
}
