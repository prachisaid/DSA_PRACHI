package DynamicProgramming;

public class FrogJumpLeetcode {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,8,9,11};

        System.out.println(new FrogJumpLeetcode().canCross(arr));
    }

    public boolean canCross(int[] stones) {
        return recursive(0, 0, stones);
    }

    private boolean recursive(int ind, int k, int[] stones) {
        if(ind == stones.length - 1){
            return true;
        }

        boolean kth = false, kplus1 = false, kminus1 = false;
        for(int i = ind + 1; i < stones.length; i++) {
            int jump = Math.abs(stones[ind] - stones[i]);

            if(jump == k) {
                kth = recursive(i, jump, stones);
            }
            else if(jump == k + 1) {
                kplus1 = recursive(i, jump, stones);
            }
            else if(jump == k - 1) {
                kminus1 = recursive(i, jump, stones);
            }

            if(kth | kplus1 | kminus1) return true;
        }

        return false;
    }
}
