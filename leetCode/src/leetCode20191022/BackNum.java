/**
 * <һ�仰���ܼ���>
 * <�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������>
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


	//�򵥷���
	public static boolean isPalindrome(int x) {
		if(x<0||(x%10==0&&x!=0)){          //x<0����xĩβ��0���϶����ǻ���
			return false;
		}
		int revertedNumber = 0;
		while (revertedNumber<x){
			revertedNumber=revertedNumber*10+x%10;
			x=x/10;
		}
		return revertedNumber==x||revertedNumber/10==x;      //���x�ܳ�Ϊ��������Ҫ���м���ȥ�����ʳ���10
	}


	public static void main(String[] args) {
		//isPalindrome(12345);
		System.out.println(isPalindrome(121));
	}
}
