/**
 * <一句话功能简述>
 * <实体类>
 *
 * Person类中的方法及成员变量
 * private int id; 用户ID 属性
 * private String name; 用户姓名属性
 * private String age; 用户年龄属性
 * private String sex; 用户性别属性
 * private String telNum; 用户电话号码属性
 * private String address; 用户地址属性
 * Person() 无参数构造方法
 * Person(String name, String age, String sex, String telNum, String address) 有参数构造方法
 * getName() 读取用户名
 * setName(String name) 设置用户名
 * getAge() 读取用户年龄
 * setAge(String age) 设置用户年龄
 * getSex() 读取用户性别
 * setSex(String sex) 设置用户性别
 * getTelNum() 读取用户电话号码
 * setTelNum (String telNum) 设置用户电话号码
 * getAddress() 读取用户地址
 * setAddress(String address) 设置用户地址
 * getID () 读取用户ID号
 * setID (int ID) 设置用户ID号
 * toString() 连接字符串方法
 *
 * @author sunmeng
 * @create 2019/10/9   9:20
 */
package homework20191009;

import java.util.Objects;

public class Person {
	private int id;
	private String name;
	private String age;
	private String sex;
	private String telNum;
	private String address;

	public Person(){

	}

	public Person(int id, String name, String age, String sex, String telNum, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.telNum = telNum;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age='" + age + '\'' +
				", sex='" + sex + '\'' +
				", telNum='" + telNum + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return id == person.id &&
				name.equals(person.name) &&
				age.equals(person.age) &&
				Objects.equals(sex, person.sex) &&
				Objects.equals(telNum, person.telNum) &&
				Objects.equals(address, person.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
