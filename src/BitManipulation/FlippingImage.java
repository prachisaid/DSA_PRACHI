package BitManipulation;

import java.util.Arrays;

public class FlippingImage {
    public static void main(String[] args) {
//        int[][] image = {
//                {1, 1, 0},
//                {1, 0, 1},
//                {0, 0, 1}
//        };
//
//        image = flipAndInvertImage(image);
//        for(int[] img : image) {
//            System.out.println(Arrays.toString(img));
//        }

        String s = "10:20";
        String[] s1 = s.split(":");
        int a = Integer.parseInt(s1[0]) * 60;
        int b = Integer.parseInt(s1[1]);
        System.out.println(a + b);
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        for(int i = 0; i < image.length; i++) {
            int k = 0, j = image[i].length - 1;
            while(k < j) {
                image[i][k] = image[i][k] ^ image[i][j];
                image[i][j] = image[i][k] ^ image[i][j];
                image[i][k] = image[i][k] ^ image[i][j];
                k++;
                j--;
            }
        }

        for(int i = 0; i < image.length; i++) {
            for(int j = 0; j < image[i].length; j++) {
                if(image[i][j] == 0) {
                    image[i][j] = 1;
                }else {
                    image[i][j] = 0;
                }
            }
        }
        return image;
    }
}
