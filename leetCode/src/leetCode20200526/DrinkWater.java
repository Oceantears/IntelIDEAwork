/**
 * <һ�仰���ܼ���>
 * <p>
 * ����ˮ
 * ������һ�������⣺��ĳ�̵�涨����������ˮƿ���Ի�һƿ��ˮ��С��������ʮ������ˮƿ���������Ի�����ƿ��ˮ�ȣ���
 * ����5ƿ���������£�����9����ƿ�ӻ�3ƿ��ˮ���ȵ�3ƿ���ģ������Ժ�4����ƿ�ӣ���3���ٻ�һƿ���ȵ���ƿ���ģ�
 * ��ʱ��ʣ2����ƿ�ӡ�Ȼ�������ϰ��Ƚ����һƿ��ˮ���ȵ���ƿ���ģ������Ժ���3����ƿ�ӻ�һƿ���Ļ����ϰ塣���С��������n������ˮƿ�������Ի�����ƿ��ˮ�ȣ�
 *
 * @author sunmeng
 * @create 2020/5/26   21:13
 */
package leetCode20200526;

import java.util.Scanner;

public class DrinkWater {
	public static void main(String[] args) {
		System.out.println("�������еĿ�ƿ������");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		// count(n);
		System.out.println(count(n));
	}
	public static int count(int n){
		int count = 0;
		if(n>=1&&n<=100){
			while(n>=2){
				n=n-3+1;
				count++;
			}
		}
		return count;
	}
}
