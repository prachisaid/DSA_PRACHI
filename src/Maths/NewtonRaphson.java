package Maths;

public class NewtonRaphson {
    public static void main(String[] args) {
        System.out.println(sqrt(40));
    }

    private static double sqrt(int n) {
        double x = n;
        double root = 0.0;

        while(true) {
            root = 0.5 * (x + (n / x));

            if(Math.abs(root - x) < 0.1) {
                return root;
            }

            x = root;
        }
    }
}
