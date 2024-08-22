package POTD;

public class FindComplement {
	public static void main(String[] args) {

	}

	public int findComplement(int num) {
		int msb = (int)(Math.log(num) / Math.log(2));
		int sum = 0;
		for(int i = msb; i >= 0; i--){
			if(Math.pow(2, i) <= num)
				num -= Math.pow(2, i);
			else
				sum += Math.pow(2, i);
		}
		return sum;
	}
}
