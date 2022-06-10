package week_5;

import java.util.Scanner;

public class CoinChangeAgain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int change;
		int[] coins = {1, 3, 4};
		change = sc.nextInt();
		
		int[][] ans = new int[coins.length + 1][change + 1];
		for (int i = 0; i <= coins.length; i++) {
			ans[i][0] = 0;
		}
		for(int j = 0; j <= change; j++) {
			ans[0][j] = j;
		}
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= change; j++) {
				if (coins[i-1] > j) {
					ans[i][j] = ans[i-1][j];
				}else {
					ans[i][j] = min(ans[i-1][j], 1 + ans[i][j - coins[i - 1]]);
				}
			}
		}
		System.out.println(ans[coins.length][change]);
	}

	public static int min(int i, int j) {
		if(i < j) {
			return i;
		}else return j;
	}

}
