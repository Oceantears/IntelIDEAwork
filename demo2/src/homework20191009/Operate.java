/**
 * <一句话功能简述>
 * <业务处理类>
 *
 * Operate类中方法及成员变量
 * private Vector<Person> v 集合
 * addLogic() 用户添加信息业务逻辑控制
 * searchLogic() 用户查询信息业务逻辑控制
 * modifyLogic() 修改信息业务逻辑控制
 * deleteLogic() 删除信息业务逻辑控制
 * orderLogic() 排序信息业务逻辑控制
 * addOperation() 添加新用户信息
 * showAll() 查询全部用户信息
 * searchByName() 按姓名查询用户信息
 * searchByAge() 按年龄查询用户信息
 * searchBySex() 按性别查询用户信息
 * searchByTelNum() 按电话号码查询用户信息
 * searchByAdd() 按地址查询用户信息
 * modify() 修改指定记录信息
 * delete() 删除指定用户信息
 * deleteAll() 删除全部用户信息
 * orderName() 按用户姓名排序信息
 * orderAge() 按用户年龄排序信息
 * orderSex() 按用户性别排序信息
 *
 * @author sunmeng
 * @create 2019/10/9   9:20
 */
package homework20191009;

import java.util.Vector;

public class Operate {
	private Vector<Person> vecPerson;
	//用户添加信息业务逻辑控制
	private void addLogic(){

	}
	//用户查询信息业务逻辑控制
	private void searchLogic(){

	}
	//修改信息业务逻辑控制
	private void modifyLogic(){

	}
	//删除信息业务逻辑控制
	private void deleteLogic(){

	}
	//排序信息业务逻辑控制
	private void orderLogic(){

	}
	//添加新用户信息
	public void addOperation(){
		addLogic();
		System.out.println("添加新用户信息");
	}
	//查询全部用户信息
	public void showAll(){
		searchLogic();
		System.out.println("查询全部用户信息");
	}
	//按姓名查询用户信息
	public void searchByName(){
		searchLogic();
		System.out.println("按姓名查询用户信息");
	}
	//按年龄查询用户信息
	public void searchByAge(){
		searchLogic();
		System.out.println("按年龄查询用户信息");
	}
	//按性别查询用户信息
	public void searchBySex(){
		searchLogic();
		System.out.println("按性别查询用户信息");
	}
	//按电话号码查询用户信息
	public void searchByTelNum(){
		searchLogic();
		System.out.println("按电话号码查询用户信息");
	}
	//按地址查询用户信息
	public void searchByAdd(){
		searchLogic();
		System.out.println("按地址查询用户信息");
	}
	//修改指定记录信息
	public void modify(String str){
		modifyLogic();
		System.out.println("修改指定记录信息");
	}
	//删除指定用户信息
	public void delete(){
		deleteLogic();
		System.out.println("删除指定用户信息");
	}
	//删除全部用户信息
	public void deleteAll(){
		deleteLogic();
		System.out.println("删除全部用户信息");
	}
	//按用户姓名排序信息
	public void orderName(){
		orderLogic();
		System.out.println("按用户姓名排序信息");
	}
	//按用户年龄排序信息
	public void orderAge(){
		orderLogic();
		System.out.println("按用户年龄排序信息");
	}
	//按用户性别排序信息
	public void orderSex(){
		orderLogic();
		System.out.println("按用户性别排序信息");
	}
}
