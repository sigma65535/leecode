package com.leetcode;
/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False*/
public class Detect_Capital {
    
    /*
     * word 1.第一个字母是小写时，后边全是小写，则true.
     * 	    2..........大写时，后边是大小写一直，则true.
     * 	    
     */

    public boolean detectCapitalUse(String word) {
    	// word len的长度 = 1 
    	int len = word.length();
    	if(len == 1) return true;
    	int lower = ('a'<=word.charAt(0))?1:0;
    	boolean b = false;
    	
//    	if(lower == 1){
//    		b = allUpperOrLower(0,len-1,word);
//    	}
//
//    	if(lower == 0){
//    		b = allUpperOrLower(1,len-1,word);
//    	}
    	b = allUpperOrLower(1-lower,len-1,word);
    	
    	
    	return b;
    	
    }
    /**
     * 
     * @param start 开始索引
     * @param end	结束索引
     * @param s 判断的字符串
     * @return  true:s 在[start,end]所有字符都是大写，或者都是小写 
     * @return  false:字符串区间的大小写不一致
     * 			
     */
    public boolean allUpperOrLower(int start ,int end , String s){
    	boolean res = true;
    	int upper = (s.charAt(start)>='A'&&s.charAt(start)<='Z')? 1:0;
    	if(upper == 1){
    		for (int k = start;k<=end ;k++ ) {
    			if(s.charAt(k) >= 'a') {
    				res = false;
    				break;
    			}
    		}
    	}

    	if(upper == 0){
    		for (int k = start;k<=end ;k++ ) {
    			if(s.charAt(k) <= 'Z') {
    				res = false;
    				break;
    			}
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args) {
	
	System.out.println(new Detect_Capital().detectCapitalUse("Gkljhdlkjfkl"));
	//System.out.println();
    }
}
