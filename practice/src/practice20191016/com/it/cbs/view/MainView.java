/**
 * <一句话功能简述>
 * <给MainView类添加一个类型为ZhangWuService的成员变量，因ser为本项目中view依赖vice。>
 *
 * @author sunmeng
 * @create 2019/10/16   10:46
 */
package practice20191016.com.it.cbs.view;

import practice20191016.cn.it.cbs.service.ChuBanSheService;
import practice20191016.com.it.cbs.bean.ChuBanShe;

import java.util.List;
import java.util.Scanner;

public class MainView {
	ChuBanSheService chuBanSheService=new ChuBanSheService();

	public void run(){
		boolean flag=true;
		Scanner in=new Scanner(System.in);

		while(flag){
			System.out.println("=================对数据库的操作=================");
			System.out.println("==                1.添加书籍                  ==");
			System.out.println("==                2.删除书籍                  ==");
			System.out.println("==                3.修改书籍                  ==");
			System.out.println("==                4.查询书籍                  ==");
			System.out.println("==                5.退出系统                  ==");
			System.out.println("================================================");
			System.out.println("请输入操作编号：");
			int n=in.nextInt();
			in.nextLine();

			switch (n){
				case 1:
					addBook();
					break;
				case 2:
					deleteBook();
					break;
				case 3:
					updateBook();
					break;
				case 4:
					searcheBook();
					break;
				case 5:
					System.out.println("=========退出操作=========");
					flag=false;
					break;
					default:
						System.out.println("输入错误！！");

			}
		}
	}
	public void searcheBook(){
		System.out.println("1.查询所有　2.按条件查询");

		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		scanner.nextLine();

		switch (n){
			case 1:
				selectAll();
				break;
			case 2:
				select();
				break;
				default:
					System.out.println("输入错误！");
		}
	}
	public void selectAll(){
		List<ChuBanShe> chuBanSheList=chuBanSheService.selectAll();
		print(chuBanSheList);
	}
	private void print(List<ChuBanShe> chuBanSheList){
		System.out.println("总编号\t分类号\t书名\t作者\t出版单位\t单价\t");
		for(ChuBanShe chu:chuBanSheList){
			System.out.println(chu.getBook_no()+"\t"+chu.getType_no()+"\t"+chu.getBook_name()+"\t"+chu.getAuthor()+"\t"+chu.getPublisher()+"\t"+chu.getPrice());
		}
	}
	public void select(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入出版社名称：");
		String s=scanner.nextLine();
		List<ChuBanShe> chuBanShe=chuBanSheService.select(s);
		print(chuBanShe);

	}
	public void addBook(){

	}
	public void deleteBook(){

	}
	public void updateBook(){
		Scanner scanner=new Scanner(System.in);
		ChuBanShe chu=new ChuBanShe();
		System.out.println("请输入书号：");
		chu.setBook_no(scanner.nextInt());
		scanner.nextLine();

		System.out.println("请输入书籍作者：");
		chu.setAuthor(scanner.next());

		chuBanSheService.updateBook(chu);
		System.out.println("编辑成功！！");
	}
}
