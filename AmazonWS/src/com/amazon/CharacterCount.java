package com.amazon;

public class CharacterCount {

	/**
	 * @author Sainagaraju Vaduka
	 * 
	 *  Given a string "aaabbbcc", 
	 *  compress it, = "a3b3c2" . 
	 *  Given that output string's length is always smaller than input string, 
	 *  you have do it inplace. No extra space , no arrays should be used
	 */
	final char CHAR_CONSTANT='|';
	public static void main(String[] args) 
	{
		final String str="aabbdddddddddedffffff                   fffffffffffffffffffffffsdfsfsffg";
		CharacterCount counter=new CharacterCount();
//		int count=counter.countCharInStr('b', str);
//		System.out.println("count:"+count);
		
		String output=counter.countEachCharFrequency(str);
		
		System.out.println(output);
	}
	
	public String countEachCharFrequency(final String  word)
 {
		boolean checkAnyRepeatedChar = Boolean.TRUE;
		StringBuffer computedOutput = null;

		if (checkAnyRepeatedChar) {
			computedOutput = new StringBuffer();
			char searchChar ;
			do {
				searchChar = CHAR_CONSTANT;
				searchChar = nextSearchChar(word, computedOutput);

				if (searchChar != CHAR_CONSTANT) 
				{
					int searchCount = countCharInStr(searchChar, word);
					computedOutput.append(searchChar);
					computedOutput.append(searchCount);
				}
			} while (searchChar != CHAR_CONSTANT);
		}
		System.out.println("Computed Output:"+computedOutput);
		return computedOutput!=null && computedOutput.length()<=word.length()?computedOutput.toString():"";
		
	}
	
	public char nextSearchChar(final String word, StringBuffer result){
		char searchChar=CHAR_CONSTANT;
		char tempChar=CHAR_CONSTANT;
		boolean isSearchCharAlreadyComputed=Boolean.FALSE;
		for (int i = 0; i < word.length(); i++) 
		{
			tempChar=word.charAt(i);
			isSearchCharAlreadyComputed=checkCharExistInStr(tempChar, result);
		
			if(!isSearchCharAlreadyComputed)
			{
				searchChar=tempChar;
				break;	
			}
		}
		return searchChar;
	}
	public boolean checkCharExistInStr(final char searchChar,final StringBuffer result)
	{
		boolean isAlreadyComputed=Boolean.FALSE;
	
		for (int i = 0; i < result.length(); i++) {
			if(searchChar==result.charAt(i)){
				isAlreadyComputed=Boolean.TRUE;
				break;
			}
		}
		
		return isAlreadyComputed;
	}

	public boolean validateAnyCharRepeated(final String word)
	
	{
		boolean proceedWithCount=Boolean.FALSE;
		
		boolean isAnyCharRepeted=Boolean.FALSE;
		char repeatedChar=CHAR_CONSTANT;
		String nextStr=null;
		int iReapetedCount=0;
		for (int i = 0; i < word.length(); i++) 
		{
			repeatedChar=word.charAt(i);
			if(i<word.length()-1)
			{
			nextStr=word.substring(i+1);
			isAnyCharRepeted=checkCharExistInStr(repeatedChar, new StringBuffer(nextStr));
			if(isAnyCharRepeted){
				iReapetedCount++;
			}
			}
		}
		if(iReapetedCount>=(word.length()/2)){
			proceedWithCount=Boolean.TRUE;
		}
		return proceedWithCount;
	}
	
	public int countCharInStr(final char searchChar, final String word)
	{
		if (word.length() == 1) {
			if (word.charAt(0) == searchChar) {
				return 1;
			} else {
				return 0;
			}
		}
		char tempSearchChar = CHAR_CONSTANT;// Non Character
		String remainingWord = null;
	
		for (int i = 0; i < word.length(); i++) 
		{
			tempSearchChar = word.charAt(i);
			
			if (tempSearchChar == searchChar) 
			{
				remainingWord = word.substring(i + 1, word.length());
				
				return 1+countCharInStr(searchChar, remainingWord);
			}
		}

		return 0;
	}
}
