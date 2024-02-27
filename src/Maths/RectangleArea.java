package Maths;

public class RectangleArea {
    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int widthA = ax2 - ax1;
        int heightA = ay2 - ay1;

        int widthB = bx2 - bx1;
        int heightB = by2 - by1;

        int area = (widthA * heightA) + (widthB * heightB);

        // check for intersection

        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);

        if((right - left < 0) || (top - bottom < 0)) {
            return area;
        }
        else {
            int intArea = (right - left) * (top - bottom);
            return area - intArea;
        }
    }
}
