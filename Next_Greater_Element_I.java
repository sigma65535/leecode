package com.leetcode;
/*You are given two arrays (without duplicates) nums1 and nums2
 *  where nums1’s elements are subset of nums2. 
 *  Find all the next greater numbers for nums1's elements 
 *  in the corresponding places of nums2.
 *  The Next Greater Number of a number x in nums1 is the first greater number 
 *  to its right in nums2. If it does not exist, output -1 for this number.
*/
public class Next_Greater_Element_I {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
	
	//1.遍历findNums，记录当前元素 curNum
	//2.nums 找==curNum ---findNum
	//3.记录findNum的 记录index ,(index ~ length-1)遍历找到nums 下一个大数
	int curNum = -1;
	int[] result = new int[findNums.length];
	int index = -1;
	for (int i = 0; i < findNums.length; i++) {
	    result[i] = -1;
	    curNum = findNums[i];
	    index = findIndex(nums, curNum);
	    
	    if(index >= 0){
		int k = index+1;
		for (; k < nums.length; k++) {
		    if(curNum < nums[k]  ){
			result[i] = nums[k];
			break;
		    }else{
			result[i] = -1;
		    }   
		}
	    }
	   
	}
///
	return result;
        
    }

    private int findIndex(int[] nums, int curNum) {
	int index = -1;
	for (int j = 0; j < nums.length; j++) {
        	if (curNum == nums[j]) {
        	    index =j;
        	    break;
        	}
	}
	return index;
    }
    
    public static void main(String[] args) {
	Next_Greater_Element_I s = new Next_Greater_Element_I();
	int[] findNums ={2,4} ;
	int[] nums ={1,2,3,4};	
	int[] result = s.nextGreaterElement(findNums, nums);
	for (int n : result) {
	    System.out.print(n+" |");
	}
    }
}