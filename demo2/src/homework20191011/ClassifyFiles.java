/**
 * <一句话功能简述>
 *
 * <5.键盘录入一个文件夹路径,统计该文件夹(包含子文件夹)中每种类型的文件及个数,注意:用文件类型(后缀名,不包含.(点),如："java","txt")作为key,
 * 	用个数作为value,放入到map集合中,并用两种方式遍历map集合
 * 	例如：
 * 	doc 的类型的文件有  3 个
 * 	java 的类型的文件有  5 个
 * 	txt 的类型的文件有  7 个>
 *
 * @author sunmeng
 * @create 2019/10/12   9:30
 */
package homework20191011;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassifyFiles {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入文件夹的路径：");
		// String s=scanner.nextLine();
		String s="D:\\file_test";
		File folder=new File(s);
		//classifyFiles(folder);
		System.out.println(classifyFiles(folder));

	}

	//递归查找文件后缀进行筛选
	static Map<String,Integer> maps=new HashMap<>();

	public static Map<String,Integer> classifyFiles(File file){
		File[] files=file.listFiles();


		for (File f:files) {
			if(f.isFile()){
				String s=getSuffix(f.getName());          //获取文件后缀

				//System.out.println(getSuffix(f.getName()));
				if(maps.containsKey(s)){
					int n=maps.get(s);                      //获取map中对应key的value值
					n++;
					maps.put(s,n);
				}else {
					maps.put(s,1);
				}
			}
			else {
				//遍历子文件夹，统计相同文件
				classifyFiles(f);
			}
		}
		return maps;
	}

	//截取文件名后缀
	public static String getSuffix(String fileName){
		int index=fileName.lastIndexOf(".");
		String suffix=fileName.substring(index+1);
		return suffix;
	}
}
