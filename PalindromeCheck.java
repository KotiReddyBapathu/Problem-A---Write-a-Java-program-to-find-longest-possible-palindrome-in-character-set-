package com.kotireddybapathu;

import java.util.HashSet;
import java.util.Set;

public class PalindromeCheck {

	public static int largestPalindromeCharLength = 0;
	public static String largestPalindromeChar = null;
	public static void main(String[] args) {
		try{
			String input = "eHelloWelcomeemoclewOOHelloolle";
			
			// step 1
			// find all possible combinations from given input and store in combinations 
			
			Set<String> combinations = new HashSet<String>();
			
			for (int i = 0; i < input.length(); i++) {
				String word = "";
				for (int j = i; j < input.length(); j++) {
						word = word+input.charAt(j);
						if(word.length()>1 && String.valueOf(word.charAt(0)).equalsIgnoreCase(String.valueOf(word.charAt(word.length()-1))))
							combinations.add(word);
				}
			}
			System.out.println("all combinations : "+combinations.size());
			// step 2
			// check each word in  combinations 
			// case 1 :  length of word is even
			// case 2 :  length of word is odd
			// check palindrome case then add to palindromeList
			Set<String> palindromeList = new HashSet<String>();
			for (String k : combinations) {
				if(k.length()%2==0){
					// even case
					int midPoint = k.length()/2;
					String part1 = k.substring(0, midPoint);
					String part2 = getReverseData(k.substring(midPoint, k.length()));
					if(part1.equalsIgnoreCase(part2)){
						palindromeList.add(k);
					}
				}
				else{
					// odd case
					int midPoint = k.length()/2;
					String part1 = k.substring(0, midPoint);
					String part2 = getReverseData(k.substring(midPoint+1, k.length()));
					if(part1.equalsIgnoreCase(part2)){
						palindromeList.add(k);
					}
				}
			
			}
			System.out.println("all palindrome combinations : "+palindromeList.size());
			// step 3
			// check largest palindrome 
			for (String palindrome : palindromeList) {

				if(palindrome.length()>largestPalindromeCharLength){
					largestPalindromeCharLength =palindrome.length();
					largestPalindromeChar = palindrome;
				}
			
			}
			
			System.out.println("FINAL ANSWER : "+largestPalindromeChar+" with length : "+largestPalindromeCharLength);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String getReverseData(String in) {
		String res = "";
		for (int i = in.length()-1; i>=0 ; i--) {
			res=res+in.charAt(i);
		}
		return res;
	}

}
