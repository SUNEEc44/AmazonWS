package com.amazon;

public class ArrayTest {
	private static int[] input = new int[100];
	

	/**
	 * @param printArray
	 * Print the array
	 */
	public static void printInput(final int[] printArray)
	{
		
		if(printArray==null)
		{
			System.out.println("Product Array got null");
			return;
		}
		
		for (int i = 0; i < printArray.length; i++) {
			System.out.print(i+"-->"+printArray[i]+"\t");
		}
		System.out.println("\r\n----------------------------------");
	}
	
	
	public static void main(String[] args) 
	{
		for (int i = 0; i < input.length; i++) 
		{
			input[i]=(int) ((int)100*Math.random());
		}
		
		printInput(input);
		
		process(input);
		
		
	}
	
	public static void process(final int[] processArray){
		
		for (int i = 0; i < processArray.length; i++) {
			final int[] productArray=getProductArray(i, processArray);
			System.out.print("product Array::::"+i+"\t");
			printInput(productArray);
			
		}
	}
	
	/**
	 * 
	 * @param i
	 * @param inputArray
	 * @return product array where i element will be removed.
	 */
	
	public static int[] getProductArray(final int i, final int[] inputArray)
	{
		int[] productArray=null;
		
		if(inputArray!=null && inputArray.length>1 && i<inputArray.length)
		{
			
			productArray=new int[inputArray.length-1];
			
			for (int j = 0; j < inputArray.length; j++) 
			{
				if(j==i){
					continue;
				}else if(j>=i){
					productArray[j-1]=inputArray[j];
				}else{
					productArray[j]=inputArray[j];
				}
				
			}
		
		}
		return productArray;
	}
	
}