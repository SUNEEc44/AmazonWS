package com.amazon;

public class ParcelTest {
	
	private int five_rupee_stamps=10;
	private int ten_rupee_stamps=10;
	private int twenty_rupee_stamps=10;
	private int fifty_rupee_stamps=10;
	

	public static void main(String[] args) {
		
		final double input=100;
		
		
		int[] stampValues={5,10,20,50};
		
		long result=stampValues[0];
		for (int i=1;i<stampValues.length;i++) {
			result=lcm(result, stampValues[i]);
		}
		
		System.out.println(result);
		
//
//		final long gcd=gcd(252, 105);
//		
//		System.out.println(gcd);
	}

	
	public static long gcd( long a, long b){
	
		while(b>0){
			long temp=b;
			b=a%b;
			a=temp;
			System.out.println("b--->"+b+"\ta---->"+a);
		}
		
		return a;
	}
	
	public static long lcm(long a , long b){
		
		return a * (b / gcd(a, b));
		
	}
}
