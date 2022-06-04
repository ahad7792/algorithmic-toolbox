package week_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Organizing_lottery {
	
	public static class Data{
		long value;
		int type;
		int id;
		public Data(int left, int type, int id) {
			this.value = left;
			this.type = type;
			this.id = id;
		}
		
	}
	
	public static class Comp implements Comparator<Data>{

		@Override
		public int compare(Data o1, Data o2) {
			if (o1.value != o2.value) {if(o1.value < o2.value) return 1;}
		    else {if(o1.type < o2.type) return 1;}
			return -1;
		}
		
	}
	
    static int cnt = 0;
    static List<Data> data = new ArrayList<>();
    static int[] result = new int[50007];
    
    public static void main(String[] args) {
    	int s, p;
    	int left,right,pt;
    	Scanner scanner = new Scanner(System.in);
    	s = scanner.nextInt();
    	p = scanner.nextInt();
    	for(int i = 0; i < s; ++i) {
    		left = scanner.nextInt();
    		right = scanner.nextInt();
    		data.add(new Data(left, 0, -1));
    		data.add(new Data(right, 2, -1));
    	}
    	for(int i = 0; i < p; ++i) {
    		pt = scanner.nextInt();
    		data.add(new Data(pt, 1, i));
    	}
    	Collections.sort(data, new Comp());
    	int cntLeft = 0;
    	for(Data data : data) {
    		if(data.type == 0) cntLeft++;
    		else if(data.type == 2) cntLeft--;
    		else if(data.type == 1) result[data.id] = cntLeft;
    	}
    	for(int i = 0; i < p; ++i) {
    		System.out.print(result[i] * -1 + " ");
    	}
    }
}


