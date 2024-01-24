package questions;

import java.util.Arrays;

public class EliminitateMaxMonsters {
    public static void main(String[] args) {
        int[] dist = {1, 1, 2, 3};
        int[] speed = {1, 1, 1 , 1};

        EliminitateMaxMonsters el = new EliminitateMaxMonsters();
        System.out.println(el.eliminateMaximum(dist, speed));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] timer = new double[dist.length];

        for(int i = 0; i < dist.length; i++) {
            timer[i] = ((double) dist[i] / speed[i]);
        }


        Arrays.sort(timer);
        System.out.println(Arrays.toString(timer));

        int t = 0;
        int ans  = 0;

        for(int i = 0; i < timer.length; i++){
            if (t >= timer[i]) {
                return ans;
            }
            ans++;
            t++;
        }

        return ans;
    }

}
