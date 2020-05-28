/**
 * <一句话功能简述>
 * <p>
 * 换汽水
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”
 * 答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，
 * 这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 *
 * @author sunmeng
 * @create 2020/5/26   21:13
 */
package leetCode20200526;

import java.util.Scanner;

public class DrinkWater {
	public static void main(String[] args) {
		System.out.println("请输入有的空瓶数量：");
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
