package recursion;

public class DiceRoll {
    public static void main(String[] args) {
        diceRolls("", 4);
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
}
