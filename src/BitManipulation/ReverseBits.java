package BitManipulation;
import java.util.*;
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverse(0));
    }

    public static long reverse(long a) {
        ArrayList<Integer> lst = new ArrayList<>();

        int cnt = 0;
        int mask = 1;

        while(cnt != 32) {
            if((a & mask) == 1){
                lst.add(cnt);
            }
            a = a >> 1;
            cnt += 1;
        }

        System.out.println(lst);
        mask = 1;
        a = 0;

        for(int i = 0; i < lst.size(); i++) {
            a = a | (1L << (31 - lst.get(i)));
        }

        return a;
    }

    public class Solution {
        public long reverse(long a) {
            long res =0;
            for(int i=0;i<32;i++){
                if((a&1)==1){
                    res = res | (1L<<31-i);

                }
                a=a>>1;
            }
            return res;
        }
    }


}
