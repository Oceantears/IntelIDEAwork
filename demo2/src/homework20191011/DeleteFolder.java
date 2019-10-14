/**
 * <一句话功能简述>
 * <3.从键盘接收一个文件夹路径,删除该文件夹。>
 *
 * @author sunmeng
 * @create 2019/10/11   21:10
 */
package homework20191011;

import java.io.File;
import java.util.Scanner;

public class DeleteFolder {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//String s=scanner.nextLine();
		String s="D:\\file_test";

		File folder=new File(s);
		//File parentFile=folder.getParentFile();
		//递归删除文件夹内的文件

		while (true){
			if(folder.list().length>0){
				deleteFile(folder);
			}
			else {
				//删除主文件夹
				folder.delete();
				System.out.println("删除完成。");
				break;
			}
		}

		// String[] filesName=parentFile.list();
		// for (String name:filesName) {
		// }

	}
	public static void deleteFile(File file){
		File[] files=file.listFiles();
		for(File f:files){
			if(f.isFile()){
				f.delete();
			}
			else if(f.isDirectory()){
				String[] name=f.list();
				if(name.length==0){
					f.delete();
				}
				else {
					deleteFile(f);
				}
			}
		}
	}
}
