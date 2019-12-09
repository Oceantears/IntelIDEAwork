/**
 * <一句话功能简述>
 *
 * <给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。>
 *
 * @author sunmeng
 * @create 2019/10/21   16:09
 */
package leetCode20191021;


public class LongerString {
	public static int lengthOfLongestSubstring(String s) {
		char[] chars=s.toCharArray();
		int maxLength=0;
		int startIndex=0;
		//选定结束点j，从前往后遍历，截取字符串
		for(int j=0;j<chars.length;j++){
			for(int k=startIndex;k<j;k++){
				if(chars[k]==chars[j]){
					startIndex=k+1;             //重复以后起点向后移动一位
					break;
				}
			}
			if(j-startIndex+1>maxLength){
				maxLength=j-startIndex+1;
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcbcbb"));

	}
}
