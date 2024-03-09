package SlidingWindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInWindowSizeK {
    public static void main(String[] args) {

    }
    public long[] printFirstNegativeInteger(long[] A, int N, int K)
    {
        Queue<Long> q = new LinkedList<>();
        long[] ans = new long[N - K + 1];

        int i = 0, j = 0, ind = 0;

        while(j < N) {
            if(A[j] < 0) {
                q.offer(A[j]);
            }

            if((j - i + 1) < K) {
                j++;
            }

            else if((j - i + 1) == K) {
                if(q.size() == 0) {
                    ans[ind] = 0;
                    ind++;
                }
                else {
                    ans[ind] = q.peek();
                    ind++;
                }

                if(!q.isEmpty() && A[i] == q.peek()) {
                    q.poll();
                }
                i++;
                j++;
            }
        }

        return ans;
    }
}
