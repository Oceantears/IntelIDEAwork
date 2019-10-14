/**
 * <一句话功能简述>
 * <1.从键盘接收两个文件夹路径,把其中一个文件夹中(包含内容)拷贝到另一个文件夹中>
 *
 * @author sunmeng
 * @create 2019/10/13   22:14
 */
package homework20191013;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class CopyWords {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//获取需要输出的文件夹路径
		System.out.println("请输入输出文件的文件夹的路径：");
		String s1=scanner.nextLine();
		System.out.println("请输入输入文件的文件夹的路径：");
		String s2=scanner.nextLine();

		FileInputStream fis=null;
		FileOutputStream fos=null;

		
	}
}
