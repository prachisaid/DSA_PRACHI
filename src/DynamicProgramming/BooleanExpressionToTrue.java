package DynamicProgramming;

public class BooleanExpressionToTrue {
    public static void main(String[] args) {
        String str = "F|T^F";
        System.out.println(new BooleanExpressionToTrue().evaluate(str));
    }

    public int evaluate(String exp) {
        int n = exp.length();
        return recursive(exp, 0, n - 1, 1);
    }

    private int recursive(String exp, int i, int j, int isTrue) {
        if(i > j) return 0;
        if(i == j) {
            if(isTrue == 1) return exp.charAt(i) == 'T' ? 1 : 0;
            else return exp.charAt(i) == 'F' ? 1 : 0;
        }

        int ways = 0;

        for(int k = i + 1; k <= j - 1; k += 2) {
            int lT = recursive(exp, i, k - 1, 1);
            int lF = recursive(exp, i, k - 1, 0);
            int rT = recursive(exp, k + 1, j, 1);
            int rF = recursive(exp, k + 1, j, 0);

            char operator = exp.charAt(i);

            if(operator == '&') {
                if(isTrue == 1)
                    ways = ways + (lT * rT);

                else
                    ways = ways + (lT * rF) + (lF * rT) + (lF * rF);
            }

            else if(operator == '|') {
                if(isTrue == 1)
                    ways = ways + (lT * rT) + (lT * rF) + (lF * rT);

                else
                    ways = ways + (lF * rF);
            }

            else {
                if(isTrue == 1)
                    ways = ways + (lT * rF) + (lF * rT);

                else
                    ways = ways + (lF * rF) + (lT * rT);
            }
        }

        return ways;
    }
}
