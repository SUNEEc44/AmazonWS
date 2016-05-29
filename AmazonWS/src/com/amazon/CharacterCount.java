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
	public static void main(String[] args) 
	{
		final String str="aaabbbcc";
		CharacterCount counter=new CharacterCount();
		int count=counter.countCharInStr('b', str);
		System.out.println("count:"+count);
	}
	
	public String countEachCharFrequency(final String  word)
	{
		return null;
	}

	public boolean validateStr(final String word)
	{
		return Boolean.TRUE;
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
		char tempSearchChar = '0';// Non Character
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
