/**
 * <һ�仰���ܼ���>
 * <����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת�������ת�����������ô�ͷ��� 0��>
 *
 * @author sunmeng
 * @create 2019/10/21   15:29
 */
package leetCode20191021;

public class NumSort {
	public static int reverse(int x) {
		int result=0;
		long getResult=0L;

		//��ȡ��ת��
		while (true){
			int singer=x%10;         //��ȡx�ĸ�λ��
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


	//��һ�ֽⷨ


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


