/**
 * <һ�仰���ܼ���>
 *
 * <������ʵ��һ��atoi������ʹ���ܽ��ַ���ת����������
 * ���ȣ��ú����������Ҫ�������õĿ�ͷ�ո��ַ���ֱ��Ѱ�ҵ���һ���ǿո���ַ�Ϊֹ��
 * ������Ѱ�ҵ��ĵ�һ���ǿ��ַ�Ϊ�����߸���ʱ���򽫸÷�����֮���澡���ܶ���������������������Ϊ�������������ţ�
 * �����һ���ǿ��ַ������֣���ֱ�ӽ�����֮�������������ַ�����������γ�������
 * ���ַ���������Ч����������֮��Ҳ���ܻ���ڶ�����ַ�����Щ�ַ����Ա����ԣ����Ƕ��ں�����Ӧ�����Ӱ�졣
 * ע�⣺������ַ����еĵ�һ���ǿո��ַ�����һ����Ч�����ַ����ַ���Ϊ�ջ��ַ����������հ��ַ�ʱ������ĺ�������Ҫ����ת����
 * ���κ�����£����������ܽ�����Ч��ת��ʱ���뷵�� 0
 *
 * ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/string-to-integer-atoi >
 *
 * @author sunmeng
 * @create 2019/10/18   14:39
 */
package leetCode20191018;

import java.util.regex.Pattern;

public class Solution {
	public static int myAtoi(String str){
		int out=0;
		//ȥ��ͷ�Ŀո�
		String str1=str.trim();
		//�ָ��ַ������õ��ַ�������
		String[] str2=str1.split("\\s+");
		//��õ�һ���ַ�
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
		int endIndex=0;             //���һ�����ֵ�����
		//��ȡ�ַ��������ֲ���
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
