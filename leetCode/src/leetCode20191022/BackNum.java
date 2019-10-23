/**
 * <一句话功能简述>
 * <判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。>
 *
 * @author sunmeng
 * @create 2019/10/22   15:29
 */
package leetCode20191022;

public class BackNum {
	// public static boolean isPalindrome(int x) {
	// 	boolean isBackNum=true;
	// 	if(x<0){
	// 		isBackNum=false;
	// 	}
	// 	if(x==0){
	// 		isBackNum= true;
	// 	}
	// 	if(x>0){
	// 		String s=Integer.toString(x);
	// 		for(int i=0;i<s.length()/2+1;i++){
	// 			if(s.charAt(i)!=s.charAt(s.length()-i-1)){
	// 				isBackNum=false;
	// 			}
	// 		}
	// 	}
	// 	return isBackNum;
	// }


	//简单方法
	public static boolean isPalindrome(int x) {
		if(x<0||(x%10==0&&x!=0)){          //x<0或者x末尾是0，肯定不是回文
			return false;
		}
		int revertedNumber = 0;
		while (revertedNumber<x){
			revertedNumber=revertedNumber*10+x%10;
			x=x/10;
		}
		return revertedNumber==x||revertedNumber/10==x;      //如果x总长为奇数，需要把中间数去除，故除以10
	}


	public static void main(String[] args) {
		//isPalindrome(12345);
		System.out.println(isPalindrome(121));
	}
}
