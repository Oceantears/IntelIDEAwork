/**
 * <一句话功能简述>
 * <给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。如果反转后整数溢出那么就返回 0。>
 *
 * @author sunmeng
 * @create 2019/10/21   15:29
 */
package leetCode20191021;

public class NumSort {
	public static int reverse(int x) {
		int result=0;
		long getResult=0L;

		//获取反转数
		while (true){
			int singer=x%10;         //获取x的个位数
			getResult=getResult*10+singer;
			x=x/10;
			if (x==0){
				break;
			}
		}

		if(getResult<Integer.MIN_VALUE||getResult>Integer.MAX_VALUE){
			result=0;
		}
		else
			result=(int)getResult;
		return result;
	}


	public static void main(String[] args) {
		System.out.println(reverse(-100));
	}


	//另一种解法


	//
	// public int reverse(int x) {
	// 	long rst=0;
	// 	while(x!=0){
	// 		rst= rst*10+ x%10;
	// 		x=x/10;
	//
	// 	}
	// 	if((int)rst!=rst){
	// 		return 0;
	//
	// 	}else{
	// 		return (int)rst;
	// 	}
	// }
}


