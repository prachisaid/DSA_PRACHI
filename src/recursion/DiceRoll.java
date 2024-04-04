package recursion;

public class DiceRoll {
    public static void main(String[] args) {
        diceRolls("", 4);
        System.out.println("Number of dice rolls " + diceRolls1(4));
    }

    static void diceRolls(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            diceRolls(p + i, target - i);
        }
    }

    static int diceRolls1(int target) {
        if(target == 0) {
            return 1;
        }

        int count = 0;

        for(int i = 1; i <= 6; i++) {
            if(i <= target) {
                count += diceRolls1(target - i);
            }
        }

        return count;
    }
}
