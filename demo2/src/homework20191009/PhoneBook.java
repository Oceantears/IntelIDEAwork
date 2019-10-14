/**
 * <一句话功能简述>
 * <电话簿的执行程序>
 *
 *App类中方法（无成员变量）：
 * main() 程序入口函数
 * start() 主菜单控制
 *
 * @author sunmeng
 * @create 2019/10/9   9:13
 */
package homework20191009;

public class PhoneBook {
	public static void main(String[] args) {
		start();
	}
	public static void start(){
		Menu menu=new Menu();
		menu.mainMenu();
	}
}
