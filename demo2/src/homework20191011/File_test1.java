/**
 * <一句话功能简述>
 *
 * <1.使用文件名称过滤器筛选将指定文件夹下的小于200K的小文件获取并打印。>
 *
 * @author sunmeng
 * @create 2019/10/11   14:19
 */
package homework20191011;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

class MyFileFilter implements FilenameFilter{

	@Override
	//dir    the directory in which the file was found.
	//name   the name of the file.
	public boolean accept(File dir, String name) {
		File file=new File(dir,name);

		return file.length()<200*1024;
	}
}

public class File_test1 {
	public static void main(String[] args) {
		//String pathName="C:\\Users\\sunmeng\\Desktop\\10-11-File\\25-文件\\笔记";
		try {
			creatFiles();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("文件已经存在。");
		}

		File filesBox=new File("D:\\file_test");

		String[] names=filesBox.list();
		int folderNum=0;
		int fileNum=0;
		for (String name:names) {
			System.out.println(name);
			if(name.contains(".")){
				fileNum++;
			}
			else {
				folderNum++;
			}
		}
		System.out.println("文件夹："+filesBox.getName()+"中有"+fileNum+"个文件；");
		System.out.println("文件夹："+filesBox.getName()+"中有"+folderNum+"个文件夹；");

		//用过滤器类进行文件筛选
		File[] files=filesBox.listFiles(new MyFileFilter());
		System.out.println(filesBox.getName()+"下小于200K的小文件:");
		for (File file:files) {
			System.out.print(file.getName()+"\t");
		}


	}
	private static void creatFiles() throws IOException {
		File filesBox=new File("D:\\file_test");
		boolean b=filesBox.mkdir();    //创建文件夹file_test
		System.out.println(filesBox.getName()+"是否是个文件夹:"+filesBox.isDirectory());

		//创建各种类型的文件
		File f1=new File("D:\\file_test","f1.java");
		File f2=new File("D:\\file_test","f2.cs");
		File f3=new File("D:\\file_test","f3.html");
		File f4=new File("D:\\file_test","f4.pdf");
		File f5=new File("D:\\file_test","f5.java");
		File f6=new File("D:\\file_test","f6.txt");
		File f7=new File("D:\\file_test","f7.txt");
		File f8=new File("D:\\file_test","f8.java");
		File f9=new File("D:\\file_test","Java");
		File f10=new File("D:\\file_test","C#");
		File f11=new File(f9.getPath(),"f11.java");

		f1.createNewFile();
		f2.createNewFile();
		f3.createNewFile();
		f4.createNewFile();
		f5.createNewFile();
		f6.createNewFile();
		f7.createNewFile();
		f8.createNewFile();
		f9.mkdir();
		f10.mkdir();
		f11.createNewFile();
	}
}
