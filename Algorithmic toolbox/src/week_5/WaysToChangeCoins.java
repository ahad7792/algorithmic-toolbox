package week_5;

import java.util.Scanner;

public class WaysToChangeCoins {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coin, numberOfCoins, change;
		System.out.println("Enter the number of coins: ");
		numberOfCoins = sc.nextInt();
		int[] coins = new int[numberOfCoins];
		System.out.println("Enter the coins: ");
		for (int i = 0; i < numberOfCoins; i++) {
			coin = sc.nextInt();
			coins[i] = coin;
		}
		System.out.println("Enter the change: ");
		change = sc.nextInt();
		
		int[][] ans = new int[coins.length][change];
		for (int i = 0; i < coins.length; i++) {
			ans[i][0] = 1;
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j < change; j++) {
				if (coins[i] > j) {
					ans[i][j] = ans[i-1][j];
				}else {
					ans[i][j] = ans[i][j-coins[i]];
				}
			}
		}
		System.out.println(ans[coins.length-1][change-1]);
	}

}
