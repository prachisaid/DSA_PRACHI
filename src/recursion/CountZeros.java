package recursion;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(count(3020400, 0));
    }

    // How to pass values to above calls
    static int count(int n, int cnt){
        if(n == 0){
            return cnt;
        }

        if(n % 10 == 0){
            return count(n / 10, ++cnt);
        }
        else{
            return count(n / 10, cnt);
        }
    }
}
