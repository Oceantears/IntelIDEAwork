/**
 * <一句话功能简述>
 *
 * 4.从键盘接收一个文件夹路径,把文件夹中的所有文件以及文件夹的名字按层级打印
 * 	例如:
 * 	aaa是文件夹,里面有bbb.txt,ccc.txt,ddd.txt这些文件,有eee这样的文件夹,eee中有fff.txt和ggg.txt,打印出层级来
 * 	aaa
 * 		bbb.txt
 * 		ccc.txt
 * 		ddd.txt
 * 		eee
 * 			fff.txt
 * 			ggg.txt
 *
 * @author sunmeng
 * @create 2019/10/12   9:08
 */
package homework20191011;

import java.io.File;

public class PrintFiles {
	public static void main(String[] args) {
		String path="C:\\Users\\sunmeng\\Desktop\\10-11-File";
		File file=new File(path);
		printFiles(file,0);
	}
	public static void printFiles(File file,int num){
		File[] files=file.listFiles();
		for (File f:files) {
			if(f.isFile()){
				for(int i=0;i<num;i++){
					System.out.print("\t");
				}
				System.out.println(f.getName());
			}
			else if(f.isDirectory()){
				for(int j=0;j<num;j++){
					System.out.print("\t");
				}
				System.out.println(f.getName());

				printFiles(f,num+1);
			}
		}
	}
}
