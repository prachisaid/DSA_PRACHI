package Maths;

public class RectangleOverlap {
    public static void main(String[] args) {
        int[] rec1 = {0, 0, 1, 1};
        int[] rec2 = {1, 0, 2, 1};
        System.out.println(isRectangleOverlap1(rec1, rec2));
    }

    // Method 1
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int x3 = rec2[0], y3 = rec2[1], x4 = rec2[2], y4 = rec2[3];

        if(x3 < x2 && y3 < y2 && x1 < x4 && y1 < y4){
            return true;
        }
        else return false;
    }

    // Method 2
    public static boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int x3 = rec2[0], y3 = rec2[1], x4 = rec2[2], y4 = rec2[3];

        int left = Math.max(x1, x3);
        int right = Math.min(x2, x4);

        int bottom = Math.max(y1, y3);
        int top = Math.min(y2, y4);

        if((right - left <= 0) || (top - bottom <= 0)) return false;
        else return true;
    }
}
