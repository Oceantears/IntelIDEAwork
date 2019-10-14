/**
 * <一句话功能简述>
 * <菜单类>
 *
 * Menu类中的方法（无成员变量）
 * mainMenu() 主菜单
 * addMenu () 添加用户菜单
 * searchMenu () 查找用户菜单
 * modifyMenu () 修改用户信息主菜单
 * subModifyMenu () 修改用户信息子菜单
 * deleteMenu () 删除用户信息菜单
 * orderMenu () 排序用户信息菜单
 *
 * @author sunmeng
 * @create 2019/10/9   9:19
 */
package homework20191009;

import java.util.*;

public class Menu {
	private String str="*************************************";

	Scanner scan=new Scanner(System.in);
	Operate operate=new Operate();

	//主菜单
	public void mainMenu(){
		System.out.println("               主菜单");
		System.out.println(str);
		System.out.println("**           1.添加记录             **");
		System.out.println("**           2.查找记录             **");
		System.out.println("**           3.修改记录             **");
		System.out.println("**           4.删除记录             **");
		System.out.println("**           5.排序记录             **");
		System.out.println("**           6.退出系统             **");
		System.out.println(str);

		System.out.println("请输入菜单序号：");
		int n=scan.nextInt();
		selectMainMenu(n);
	}
	private void selectMainMenu(int n){
		switch (n){
			case 1:
				addMenu();
				break;
			case 2:
				searchMenu();
				break;
			case 3:
				modifyMenu();
				break;
			case 4:
				deleteMenu();
				break;
			case 5:
				oderMenu();
				break;
			case 6:
				System.out.println("============退出菜单系统============");
				System.exit(0);
				break;
				default:
					System.out.println("输入数字不匹配，请重新输入。");
					mainMenu();
					break;
		}
	}

	//添加用户菜单
	public void addMenu(){
		System.out.println("           添加记录子菜单");
		System.out.println(str);
		System.out.println("**          1.添加新纪录             **");
		System.out.println("**          2.查看全纪录             **");
		System.out.println("**          3.返回上一级             **");
		System.out.println(str);

		System.out.println("请输入添加子菜单序号");
		int n=scan.nextInt();
		selectAddMenu(n);
	}
	private void selectAddMenu(int n){
		switch (n){
			case 1:
				operate.addOperation();
				break;
			case 2:
				operate.showAll();
				break;
			case 3:
				mainMenu();
				break;
				default:
					System.out.println("输入数字不匹配，请重新输入。");
					addMenu();
					break;
		}
	}

	//查找用户菜单
	public void searchMenu(){
		System.out.println("            查找记录子菜单");
		System.out.println(str);
		System.out.println("**          1.按姓名查找             **");
		System.out.println("**          2.按年龄查找             **");
		System.out.println("**          3.按性别查找             **");
		System.out.println("**          4.按号码查找             **");
		System.out.println("**          5.按住址查找             **");
		System.out.println("**          6.查看全纪录             **");
		System.out.println("**          7.返回上一级             **");
		System.out.println(str);

		System.out.println("请输入查询子菜单序号");
		int n=scan.nextInt();
		selectSearchMenu(n);
	}
	private void selectSearchMenu(int n){
		switch (n){
			case 1:
				operate.searchByName();
				break;
			case 2:
				operate.searchByAge();
				break;
			case 3:
				operate.searchBySex();
				break;
			case 4:
				operate.searchByTelNum();
				break;
			case 5:
				operate.searchByAdd();
				break;
			case 6:
				operate.showAll();
				break;
			case 7:
				mainMenu();
				break;
				default:
					System.out.println("输入数字不匹配，请重新输入。");
					searchMenu();
					break;
		}
	}

	//修改用户信息主菜单
	public void modifyMenu(){
		System.out.println("           修改记录子菜单");
		System.out.println(str);
		System.out.println("**          1.查看全纪录             **");
		System.out.println("**          2.修改指定记录           **");
		System.out.println("**          3.返回上一级             **");
		System.out.println(str);

		System.out.println("请输入修改子菜单序号");
		int n=scan.nextInt();
		selectModifyMenu(n);
	}
	private void selectModifyMenu(int n){
		switch (n){
			case 1:
				operate.showAll();
				break;
			case 2:
				subModifyMenu();
				break;
			case 3:
				mainMenu();
				break;
			default:
				System.out.println("输入数字不匹配，请重新输入。");
				modifyMenu();
				break;
		}
	}

	//修改用户信息子菜单
	public void subModifyMenu(){
		System.out.println("         修改指定记录子菜单");
		System.out.println(str);
		System.out.println("**          1.修改姓名             **");
		System.out.println("**          2.修改年龄             **");
		System.out.println("**          3.修改性别             **");
		System.out.println("**          4.修改号码             **");
		System.out.println("**          5.修改住址             **");
		System.out.println("**          6.返回上一级           **");
		System.out.println(str);

		System.out.println("请输入修改指定子菜单序号");
		int n=scan.nextInt();
		selectSubMM(n);
	}
	private void selectSubMM(int n){
		switch (n){
			case 1:
				operate.modify("姓名");
				break;
			case 2:
				operate.modify("年龄");
				break;
			case 3:
				operate.modify("性别");
				break;
			case 4:
				operate.modify("号码");
				break;
			case 5:
				operate.modify("住址");
				break;
			case 6:
				modifyMenu();
				break;
			default:
				System.out.println("输入数字不匹配，请重新输入。");
				subModifyMenu();
				break;
		}
	}

	//删除用户信息菜单
	public void deleteMenu(){
		System.out.println("            删除记录子菜单");
		System.out.println(str);
		System.out.println("**          1.查看全纪录             **");
		System.out.println("**          2.删除指定记录           **");
		System.out.println("**          3.删除全部记录           **");
		System.out.println("**          4.返回上一级             **");
		System.out.println(str);

		System.out.println("请输入删除子菜单序号");
		int n=scan.nextInt();
		selectDeleteMenu(n);
	}
	private void selectDeleteMenu(int n){
		switch (n){
			case 1:
				operate.showAll();
				break;
			case 2:
				operate.delete();          //删除单行电话
				break;
			case 3:
				operate.deleteAll();       //删除整个电话簿
				break;
			case 4:
				mainMenu();
				break;
			default:
				System.out.println("输入数字不匹配，请重新输入。");
				deleteMenu();
				break;
		}
	}

	//排序用户信息菜单
	public void oderMenu(){
		System.out.println("           排序记录子菜单");
		System.out.println(str);
		System.out.println("**          1.按姓名排序             **");
		System.out.println("**          2.按年龄排序             **");
		System.out.println("**          3.按性别排序             **");
		System.out.println("**          4.查看全部纪录           **");
		System.out.println("**          5.返回上一级             **");
		System.out.println(str);

		System.out.println("请输入排序指定子菜单序号");
		int n=scan.nextInt();
		selectOderMenu(n);
	}
	private void selectOderMenu(int n){
		switch (n){
			case 1:
				operate.orderName();
				break;
			case 2:
				operate.orderAge();
				break;
			case 3:
				operate.orderSex();
				break;
			case 4:
				operate.showAll();
				break;
			case 5:
				mainMenu();
				break;
			default:
				System.out.println("输入数字不匹配，请重新输入。");
				oderMenu();
				break;
		}
	}

}
