/**
 * <一句话功能简述>
 * <2.从键盘接收一个文件夹路径,统计该文件夹大小。>
 *
 * @author sunmeng
 * @create 2019/10/11   17:23
 */
package homework20191011;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class File_test2 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入文件夹的路径：");
		//String s=scanner.nextLine();
		String s="D:\\file_test";

		File folder=new File(s);
		System.out.println(fileLength(folder));
	}
	//筛选文件和文件夹，统计文件夹中文件的大小和
	public static Long fileLength(File file){
		File[] files=file.listFiles();
		Long Length=0L;
		for (File f: files) {
			if(f.isFile()){
				Length+=f.length();      //求文件夹里文件大小的总和
			}
			else if (f.isDirectory()){
				Length+=fileLength(f);    //求子文件夹里文件大小的总和
			}
		}

		return Length;
	}
}

