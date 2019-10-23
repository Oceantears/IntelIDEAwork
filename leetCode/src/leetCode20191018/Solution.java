/**
 * <一句话功能简述>
 *
 * <请你来实现一个atoi函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/string-to-integer-atoi >
 *
 * @author sunmeng
 * @create 2019/10/18   14:39
 */
package leetCode20191018;

import java.util.regex.Pattern;

public class Solution {
	public static int myAtoi(String str){
		int out=0;
		//去两头的空格
		String str1=str.trim();
		//分隔字符串，得到字符串数组
		String[] str2=str1.split("\\s+");
		//获得第一串字符
		String str3=str2[0];
		if(str3.length()==0){
			out=0;
		}
		else if(Pattern.matches("[-+]",str3.substring(0,1))&&str3.length()>1){
			if(str3.charAt(0)=='-'){
				out=outNum(-getNum(str3.substring(1)));
			}
			else {
				out=outNum(getNum(str3.substring(1)));
			}
		}
		else if(Pattern.matches("[0-9]",str3.substring(0,1))){
			out=outNum(getNum(str3));
		}
		else {
			out=0;
		}

		return out;
	}
	private static Long getNum(String s){
		Long num=0L;
		int endIndex=0;             //最后一个数字的索引
		//截取字符串中数字部分
		if(!Pattern.matches("[0-9]",s.substring(0,1))){
			num=0L;
		}
		else {
			for(int i=0;i<s.length();i++){

				if(!Pattern.matches("[0-9]",s.substring(i,i+1))){
					endIndex=i;
					break;
				}
				else
					endIndex=s.length();
			}
			if(endIndex>11){
				endIndex=11;
			}
			num=Long.valueOf(s.substring(0,endIndex));
		}
		return num;
	}
	private static int outNum(long longer){
		int outNum=0;
		if(longer>Integer.MAX_VALUE){
			outNum=Integer.MAX_VALUE;
		}
		else if(longer<Integer.MIN_VALUE){
			outNum=Integer.MIN_VALUE;
		}
		else {
			outNum=(int)longer;
		}
		return outNum;
	}

	public static void main(String[] args) {
		String s="-2000000000000";
		System.out.println(myAtoi(s));
	}
}
