/**
 * <一句话功能简述>
 * <p>
 * 输入流测试
 *
 * @author sunmeng
 * @create 2019/12/12   15:19
 */
package decoratorModel.java_io;

import java.io.*;
import java.util.ArrayList;

public class InputTest {
	public static void main(String[] args) {
		int c;
		BufferedReader bufferedReader;
		try {
			//设置FileInputStream，先用BufferedInputStream装饰，再用LowerCaseInputStream过滤装饰它
			InputStream in=new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("D:\\IntelIDEAwork\\designModle\\src\\decoratorModel\\java_io\\LowerCaseInputStream.java")));
			while ((c=in.read())>=0){            //读取的是ASCII的数字
				System.out.print((char)c);      //只用流读取字符，一直到文件尾端。每读一个字符，就马上将它显示出来
			}
			in.close();
			//乱码问题：需要把字节流转化成字符流UTF-8模式输出
			// BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
			// String line = null;
			// while ((line = br.readLine()) != null) {
			// 	lines.add(line);
			// }
			// br.close();


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
